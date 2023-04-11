val kordVersion = "0.8.3"

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
    implementation("dev.kord:kord-core:$kordVersion")
    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.5.0")
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
                "Main-Class" to "me.blueamethyst.packio.dcbot.PIOBackend"
            )
        }
    }
}