import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("io.github.goooler.shadow") version "8.1.7"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "dev.piotrulla.slimehub"
version = "1.0.0"

repositories {
    mavenCentral()

    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://storehouse.okaeri.eu/repository/maven-public/")
    maven("https://repo.stellardrift.ca/repository/snapshots/")
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://repo.eternalcode.pl/snapshots")
    maven("https://repo.eternalcode.pl/releases")
    maven("https://repo.piotrulla.dev/releases")
}

dependencies {
    // spigot api
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")

    // adventure messaging
    implementation("net.kyori:adventure-platform-bukkit:4.3.3")
    implementation("net.kyori:adventure-text-minimessage:4.18.0-SNAPSHOT")

    // config system
    val okaeriConfigsVersion = "5.0.5"
    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:${okaeriConfigsVersion}")
    implementation("eu.okaeri:okaeri-configs-serdes-commons:${okaeriConfigsVersion}")
    implementation("eu.okaeri:okaeri-configs-serdes-bukkit:${okaeriConfigsVersion}")

    // commands framework
    val liteCommandsVersion = "3.5.0-SNAPSHOT"
    implementation("dev.rollczi:litecommands-bukkit:$liteCommandsVersion")
    implementation("dev.rollczi:litecommands-adventure:$liteCommandsVersion")

    // eternalcode stuff
    val eternalcodeVersion = "1.1.4"
    implementation("com.eternalcode:eternalcode-commons-adventure:$eternalcodeVersion")
    implementation("com.eternalcode:eternalcode-commons-bukkit:$eternalcodeVersion")
    implementation("com.eternalcode:multification-okaeri:$eternalcodeVersion")
    implementation("com.eternalcode:multification-bukkit:$eternalcodeVersion")

    // triumph gui
    implementation("dev.triumphteam:triumph-gui:3.1.7")

    // liteskullapi
    implementation("dev.rollczi:liteskullapi:1.3.0")

    implementation("dev.piotrulla.paymc:paymc-commons-bukkit:1.0.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<JavaCompile> {
    options.compilerArgs = listOf("-Xlint:deprecation")
    options.encoding = "UTF-8"
}

bukkit {
    main = "dev.piotrulla.slimehub.witch.BukkitWitchPlugin"
    apiVersion = "1.13"
    prefix = "slimehub-witch"
    author = "Piotrulla"
    name = "slimehub-witch"
    version = "${project.version}"
    description = "witch system"
}

tasks {
    runServer {
        minecraftVersion("1.18.2")
    }
}

tasks.withType<ShadowJar> {
    archiveFileName.set("slimehub-witch v${project.version}.jar")

    exclude(
        "org/intellij/lang/annotations/**",
        "org/jetbrains/annotations/**",
        "org/checkerframework/**",
        "META-INF/**",
        "javax/**"
    )

    val prefix = "dev.piotrulla.slimehub.witch.libs"

    listOf(
        "dev.piotrulla.paymc",
        "com.eternalcode",
        "dev.triumphteam",
        "dev.rollczi",
        "net.kyori",
        "eu.okaeri",
        "org.yaml",
    ).forEach { relocate(it, prefix) }
}
