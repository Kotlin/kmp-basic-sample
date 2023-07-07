plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.jetbrains.androidApp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.jetbrains.androidApp"
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Koin
    implementation("io.insert-koin:koin-android:3.4.2")
    implementation("io.insert-koin:koin-core:3.4.2")
}