package net.even.mystictools.effect;

import net.even.mystictools.MysticTools;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> SOL_INVICTUS = registerStatusEffect("sol_invictus",
            new SolInvictusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFFD700)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of(MysticTools.MOD_ID, "sol_invictus"), 1,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MysticTools.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MysticTools.LOGGER.info("Registering Mod Effects for " + MysticTools.MOD_ID);
    }
}
