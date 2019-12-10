plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.multiplatform")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "org.konan.multiplatform"
        minSdkVersion(15)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        exclude("META-INF/main.kotlin_module")
    }
}

kotlin {
    android()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation(project(":greeting"))

    implementation("androidx.appcompat:appcompat:1.1.0")

    testImplementation("junit:junit:4.12")
}