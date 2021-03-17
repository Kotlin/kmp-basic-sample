buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
        classpath("com.android.tools.build:gradle:4.1.3")
    }
}
group = "com.jetbrains"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
