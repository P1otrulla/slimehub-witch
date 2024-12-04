package dev.piotrulla.slimehub.witch.effect;

import dev.piotrulla.slimehub.witch.WitchPotionEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WitchMemoryEffect implements WitchPotionEffect {

    private final static Random RANDOM = ThreadLocalRandom.current();

    @Override
    public void apply(Player player, EffectData data) {

    }

    @Override
    public void modify(Player player, Event event, EffectData data) {
        if (!(event instanceof PlayerDeathEvent deathEvent)) {
            return;
        }

        List<ItemStack> itemsToKeep = new ArrayList<>();

        for (ItemStack itemStack : deathEvent.getDrops()) {
            if (RANDOM.nextDouble() < data.multiplier()) {
                itemsToKeep.add(itemStack);
            }
        }

        deathEvent.getDrops().removeAll(itemsToKeep);

        for (ItemStack itemStack : itemsToKeep) {
            player.getInventory().addItem(itemStack);
        }
    }

    @Override
    public void reset(Player player) {

    }
}
