package net.even.mystictools.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.List;

public class MysticPickaxeItem extends PickaxeItem {
    private static final String XP_KEY = "MysticXP";
    private static final int MAX_XP = 100;

    public static int getMaxXp() {
        return MAX_XP;
    }

    public MysticPickaxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && !state.isAir() && miner instanceof PlayerEntity player) {
            if (state.isIn(BlockTags.PICKAXE_MINEABLE)) {
                int xp = Math.min(getXP(stack) + 1, MAX_XP);
                setXP(stack, xp);
                applyEffects(player, xp);
            }
        }
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 1) Nur auf dem Server ausführen
        // 2) Nur bei echten Spielern
        if (attacker.getWorld().isClient() || !(attacker instanceof PlayerEntity player)) {
            return true;
        }

        // Ab hier bist du sicher auf dem Server und hast einen Player
        int xp = Math.min(getXP(stack) + 1, MAX_XP);
        setXP(stack, xp);
        applyEffects(player, xp);

        // Durability-Reduktion übersprungen → unzerstörbar
        return true;
    }

    private int getXP(ItemStack stack) {
        // Lese das NbtComponent (CUSTOM_DATA) aus dem Stack
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (comp != null) {
            NbtCompound tag = comp.copyNbt();
            return tag.getInt(XP_KEY);
        }
        return 0;
    }

    private void setXP(ItemStack stack, int xp) {
        // Erstelle ein neues NBT und packe den XP-Wert rein
        NbtCompound tag = new NbtCompound();
        tag.putInt(XP_KEY, xp);

        // Wandle es in ein NbtComponent um und speichere es
        NbtComponent comp = NbtComponent.of(tag);
        stack.set(DataComponentTypes.CUSTOM_DATA, comp);
    }

    private void applyEffects(PlayerEntity player, int xp) {
        if (xp < 20) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 60, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 0));
        } else if (xp < 50) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 60, 0));
        } else {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 60, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60, 0));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack,
                              TooltipContext context,
                              List<Text> tooltip,
                              TooltipType tooltipType) {
        // Erst das Vanilla-Tooltip anhängen
        super.appendTooltip(stack, context, tooltip, tooltipType);

        // dann unsere XP-Zeile
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        int xp = comp == null ? 0 : comp.copyNbt().getInt("MysticXP");
        tooltip.add(Text.literal("XP: " + xp + " / " + MysticPickaxeItem.getMaxXp()));
    }

}