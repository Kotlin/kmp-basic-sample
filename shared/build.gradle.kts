plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.20"
    id("com.squareup.sqldelight")
    id("kotlin-parcelize")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    val coroutinesVersion = "1.6.4"
    val ktorVersion = "2.2.4"
    val sqlDelightVersion = "1.5.5"
    val dateTimeVersion = "0.4.0"
    val uuidVersion = "0.7.0"
    val koinVersion = "3.4.1"
    val truth = "1.1.3"
    val mokoVersion = "0.8.0"
    val mockkVersion = "1.12.5"
    val mokoResourcesVersion = "0.22.0"
    val securitycrypto = "1.1.0-alpha06"
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")
                implementation("com.benasher44:uuid:$uuidVersion")
                implementation("dev.icerock.moko:parcelize:$mokoVersion")
                implementation("dev.icerock.moko:resources:$mokoResourcesVersion")
                implementation("io.insert-koin:koin-core:$koinVersion")
                //implementation("io.insert-koin:koin-ktor:$koinVersion")
                //implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("io.mockk:mockk-common:${mockkVersion}")
                implementation("dev.icerock.moko:resources-test:$mokoResourcesVersion")
                implementation("io.insert-koin:koin-test:$koinVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.security:security-crypto:$securitycrypto")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.github.leoneves.todo"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.github.leoneves.todo.data"
    }
}

multiplatformResources{
    multiplatformResourcesPackage = "com.github.leoneves.todo" // required
    multiplatformResourcesClassName = "SharedResources" // optional, default MR
    multiplatformResourcesVisibility = dev.icerock.gradle.MRVisibility.Public // optional, default Public
    iosBaseLocalizationRegion = "en" // optional, default "en"
    multiplatformResourcesSourceSet = "commonMain"
}