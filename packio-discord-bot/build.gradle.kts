val kordVersion = "0.8.3"
val kordexVersion = "1.5.7-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("plugin.serialization") version "1.8.10"
}

group = "me.blueamethyst"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(project(":packio-database"))
    implementation("dev.kord:kord-core:$kordVersion")

    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    implementation("org.slf4j", "slf4j-api", "2.0.5")
    implementation("org.slf4j", "slf4j-simple", "2.0.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    compileJava {
        options.release.set(17)
        options.encoding = "UTF-8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    shadowJar {
        manifest {
            attributes(
                "Main-Class" to "me.blueamethyst.packio.dcbot.DiscordBot"
            )
        }
    }
}