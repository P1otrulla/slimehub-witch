package dev.piotrulla.slimehub.witch;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public interface WitchPotionEffect {

    void apply(Player player, EffectData data);

    void modify(Player player, Event event, EffectData data);

    void reset(Player player);

    record EffectData(WitchPotionTier tier, double multiplier) {
    }
}
