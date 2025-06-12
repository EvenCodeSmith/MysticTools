package net.even.mystictools.client;

import net.even.mystictools.MysticTools;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;
import net.even.mystictools.item.ModItems;
import net.even.mystictools.item.custom.MysticPickaxeItem;

public class MysticToolsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(
                ModItems.MYSTIC_PICKAXE,
                Identifier.of("mystictools", "xp_progress"),
                (stack, world, entity, seed) -> {
                    // XP aus dem DataComponent lesen
                    NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
                    if (comp == null) return 0f;
                    NbtCompound tag = comp.copyNbt();
                    int xp = tag.getInt("MysticXP");
                    // normalisiert auf [0.0 … 1.0]
                    float res = xp / (float) MysticPickaxeItem.getMaxXp();
                    MysticTools.LOGGER.info("Mystic XP: " + res);
                    return res;
                }
        );
    }
}