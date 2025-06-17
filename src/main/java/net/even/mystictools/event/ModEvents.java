package net.even.mystictools.event;

import net.even.mystictools.effect.ModEffects;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;

public class ModEvents {
    public static void registerEvents() {

        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity.hasStatusEffect(ModEffects.SOL_INVICTUS)) {
                return false;
            }
            return true;
        });

        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof LivingEntity livingEntity &&
                    livingEntity.hasStatusEffect(ModEffects.SOL_INVICTUS)) {
                Entity attacker = source.getAttacker();
                if (attacker instanceof LivingEntity livingAttacker) {
                    livingAttacker.setOnFireFor(4);
                }

                //return false;
            }

            return true;
        });
    }
}
