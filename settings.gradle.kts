pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.40.1"
}

rootProject.name = "What_to_see"

include(":androidApp")
include(":shared")