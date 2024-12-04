package dev.piotrulla.slimehub.witch;

import eu.okaeri.configs.OkaeriConfig;
import org.bukkit.inventory.ItemStack;

import java.time.Duration;

public class WitchPotion extends OkaeriConfig {

    private final WitchPotionType type;
    private final WitchPotionTier tier;
    private final Duration duration;
    private final ItemStack itemStack;

    WitchPotion(WitchPotionType type, WitchPotionTier tier, Duration duration, ItemStack itemStack) {
        this.type = type;
        this.tier = tier;
        this.duration = duration;
        this.itemStack = itemStack;
    }

    public String name() {
        return this.tier.name() + ":" + this.type.name();
    }

    public WitchPotionType type() {
        return this.type;
    }

    public WitchPotionTier tier() {
        return this.tier;
    }

    public Duration duration() {
        return this.duration;
    }

    public ItemStack itemStack() {
        return this.itemStack;
    }

    public static WitchPotion create(WitchPotionType type, WitchPotionTier tier, Duration duration, ItemStack itemStack) {
        return new WitchPotion(type, tier, duration, itemStack);
    }
}
