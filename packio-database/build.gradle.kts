plugins {
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.20"
}

group = "me.blueamethyst"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.6.4")
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
}