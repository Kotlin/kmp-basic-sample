pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://androidx.dev/storage/compose-compiler/repository/")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://androidx.dev/storage/compose-compiler/repository/")
    }
}

rootProject.name = "KmmSample"

include(":androidApp")
include(":shared")

