package net.even.mystictools.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SolInvictusEffect extends StatusEffect {
    protected SolInvictusEffect(StatusEffectCategory category, int color) {
        super(category, color);

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(net.minecraft.entity.LivingEntity entity, int amplifier) {
        if (entity.getHealth() < entity.getMaxHealth()) {
            entity.heal(0.5F);
        }

        if (!entity.hasStatusEffect(net.minecraft.entity.effect.StatusEffects.GLOWING)) {
            entity.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(
                    net.minecraft.entity.effect.StatusEffects.GLOWING, 40, 0, true, false));
        }
        return true;
    }


}
