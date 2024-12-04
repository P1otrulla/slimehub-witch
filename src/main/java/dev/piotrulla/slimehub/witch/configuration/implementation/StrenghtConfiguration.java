package dev.piotrulla.slimehub.witch.configuration.implementation;

import com.eternalcode.commons.adventure.AdventureLegacyColorPostProcessor;
import com.eternalcode.commons.adventure.AdventureLegacyColorPreProcessor;
import com.eternalcode.commons.adventure.AdventureUrlPostProcessor;
import dev.piotrulla.slimehub.witch.WitchPotion;
import dev.piotrulla.slimehub.witch.WitchPotionService;
import dev.piotrulla.slimehub.witch.WitchPotionTier;
import dev.piotrulla.slimehub.witch.WitchPotionType;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Exclude;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StrenghtConfiguration extends OkaeriConfig implements WitchPotionService {

    @Exclude
    private static final MiniMessage MINI_MESSAGE = MiniMessage.builder()
            .postProcessor(new AdventureUrlPostProcessor())
            .preProcessor(new AdventureLegacyColorPreProcessor())
            .postProcessor(new AdventureLegacyColorPostProcessor())
            .build();

    public Map<WitchPotionTier, WitchPotion> potions = Map.of(
            WitchPotionTier.SMALL, WitchPotion.create(
                    WitchPotionType.STRENGTH,
                    WitchPotionTier.SMALL,
                    Duration.ofDays(3),
                    ItemBuilder.from(Material.POTION)
                            .name(MINI_MESSAGE.deserialize("Mała potka siły"))
                            .lore(List.of(
                                    MINI_MESSAGE.deserialize("Czas trwania: 3d"),
                                    MINI_MESSAGE.deserialize("Co daje: +1 dmg"),
                                    Component.text(""),
                                    MINI_MESSAGE.deserialize("&aKliknij prawym aby wypić")
                            ))
                            .build()
            ),
            WitchPotionTier.MEDIUM, WitchPotion.create(
                    WitchPotionType.STRENGTH,
                    WitchPotionTier.MEDIUM,
                    Duration.ofDays(14),
                    ItemBuilder.from(Material.POTION)
                            .name(MINI_MESSAGE.deserialize("Średnia potka siły"))
                            .lore(List.of(
                                    MINI_MESSAGE.deserialize("Czas trwania: 14d"),
                                    MINI_MESSAGE.deserialize("Co daje: +2 dmg"),
                                    Component.text(""),
                                    MINI_MESSAGE.deserialize("&aKliknij prawym aby wypić")
                            ))
                            .build()
            ),
            WitchPotionTier.LARGE, WitchPotion.create(
                    WitchPotionType.STRENGTH,
                    WitchPotionTier.LARGE,
                    Duration.ofDays(14),
                    ItemBuilder.from(Material.POTION)
                            .name(MINI_MESSAGE.deserialize("Ogromna potka siły"))
                            .lore(List.of(
                                    MINI_MESSAGE.deserialize("Czas trwania: 14d"),
                                    MINI_MESSAGE.deserialize("Co daje: +4 dmg"),
                                    Component.text(""),
                                    MINI_MESSAGE.deserialize("&aKliknij prawym aby wypić")
                            ))
                            .build()
            )
    );

    @Override
    public Collection<WitchPotion> getAllPotions() {
        return Collections.unmodifiableCollection(this.potions.values());
    }
}
