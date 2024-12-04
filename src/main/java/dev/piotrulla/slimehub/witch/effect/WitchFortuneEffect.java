package dev.piotrulla.slimehub.witch.effect;

import dev.piotrulla.slimehub.witch.WitchPotionEffect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashSet;
import java.util.Set;

public class WitchFortuneEffect implements WitchPotionEffect {

    private static final Set<Material> FORTUNE_MATERIALS = new HashSet<>();

    @Override
    public void apply(Player player, EffectData data) {

    }

    @Override
    public void modify(Player player, Event event, EffectData data) {
        if (!(event instanceof BlockBreakEvent breakEvent)) {
            return;
        }

        Block block = breakEvent.getBlock();

        if (!FORTUNE_MATERIALS.contains(block.getType())) {
            return;
        }

    }

    @Override
    public void reset(Player player) {

    }
}
