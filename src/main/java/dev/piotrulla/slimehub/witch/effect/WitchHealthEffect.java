package dev.piotrulla.slimehub.witch.effect;

import dev.piotrulla.slimehub.witch.WitchPotionEffect;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class WitchHealthEffect implements WitchPotionEffect {

    @Override
    public void apply(Player player, EffectData data) {
        AttributeInstance maxHealthAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (maxHealthAttribute != null) {
            maxHealthAttribute.setBaseValue(maxHealthAttribute.getBaseValue() + data.multiplier());
        }
    }

    @Override
    public void modify(Player player, Event event, EffectData data) {
    }

    @Override
    public void reset(Player player) {
        AttributeInstance maxHealthAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (maxHealthAttribute != null) {
            maxHealthAttribute.setBaseValue(maxHealthAttribute.getBaseValue());
        }
    }
}
