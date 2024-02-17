import java.net.URI

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "us.ruciver.rubyhosting"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven {
        url = URI("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        content {
            includeGroup("org.bukkit")
            includeGroup("org.spigotmc")
        }
    }
    maven { url = URI("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = URI("https://oss.sonatype.org/content/repositories/central'") }
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
tasks.shadowJar {
    minimize()

    manifest {
        attributes["Main-Class"] = "us.ruciver.rubyhosting.Ruciver"
    }
}