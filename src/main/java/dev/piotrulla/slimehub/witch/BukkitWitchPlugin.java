package dev.piotrulla.slimehub.witch;

import dev.piotrulla.slimehub.witch.configuration.ConfigService;
import dev.piotrulla.slimehub.witch.configuration.implementation.StrenghtConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BukkitWitchPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigService configService = new ConfigService();

        StrenghtConfiguration strenghtConfiguration = configService.create(StrenghtConfiguration.class, new File(this.getDataFolder(), "strenght.yml"));
    }

    @Override
    public void onDisable() {
        getLogger().info("Witch plugin disabled");
    }
}
