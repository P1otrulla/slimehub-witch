package dev.piotrulla.slimehub.witch.effect;

import dev.piotrulla.slimehub.witch.WitchPotionEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class WitchStrenghtEffect implements WitchPotionEffect {

    @Override
    public void apply(Player player, EffectData data) {
    }

    @Override
    public void modify(Player player, Event event, EffectData data) {
        if (event instanceof EntityDamageByEntityEvent damageEvent) {
            if (damageEvent.getDamager() instanceof Player damager && damager.equals(player)) {
                double damage = damageEvent.getDamage();
                damageEvent.setDamage(damage * data.multiplier());
            }
        }
    }

    @Override
    public void reset(Player player) {

    }
}
