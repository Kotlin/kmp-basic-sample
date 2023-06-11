plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.0.0").apply(false)
    kotlin("multiplatform").version("1.8.20").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

buildscript {
    val sqlDelightVersion = "1.5.5"
    val mokoResourcesVersion = "0.22.0"

    dependencies {
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("com.android.tools.build:gradle:8.0.0")
        classpath("dev.icerock.moko:resources-generator:$mokoResourcesVersion")
    }
}