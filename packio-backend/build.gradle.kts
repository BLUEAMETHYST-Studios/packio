val ktorVersion = "2.2.4"

plugins {
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("plugin.serialization") version "1.8.10"
}

group = "me.blueamethyst"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":packio-common"))

    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.6.4")

    implementation("org.slf4j", "slf4j-api", "2.0.5")
    implementation("org.slf4j", "slf4j-simple", "2.0.5")

    //KTOR
    implementation("io.ktor", "ktor-server-core-jvm", ktorVersion)
    implementation("io.ktor", "ktor-server-netty-jvm", ktorVersion)
    implementation("io.ktor", "ktor-server-status-pages-jvm", ktorVersion)
    implementation("io.ktor", "ktor-server-default-headers-jvm", ktorVersion)
    implementation("io.ktor", "ktor-serialization-kotlinx-json-jvm", ktorVersion)
    testImplementation("io.ktor", "ktor-server-test-host", ktorVersion)

    implementation("io.ktor", "ktor-client-core", ktorVersion)
    implementation("io.ktor", "ktor-client-cio", ktorVersion)
    implementation("io.ktor", "ktor-client-content-negotiation", ktorVersion)
    implementation("io.ktor", "ktor-serialization-kotlinx-json", ktorVersion)
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.5.0")

    implementation("org.litote.kmongo:kmongo-serialization:4.8.0")
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
                "Main-Class" to "me.blueamethyst.packio.backend.PIOBackend"
            )
        }
    }
}