import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id( "com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
}

group = "org.greeting"
version = 1.0

android {
    compileSdkVersion(27)
    defaultConfig {
        minSdkVersion(15)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // Specify Kotlin/JVM stdlib dependency.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7")

    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("junit:junit:4.12")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

kotlin {
   android("androidLib")
   
   val buildForDevice = project.findProperty("device") as? Boolean ?: false
   val iosTarget = if(buildForDevice) iosArm64("ios") else iosX64("ios")
   iosTarget.binaries {
      framework {
         // Disable bitcode embedding for the simulator build.
         if (!buildForDevice) {
            embedBitcode("disable")
         }
      }
   }

   sourceSets {
      commonMain {
         dependencies {
            implementation( "org.jetbrains.kotlin:kotlin-stdlib-common")
         }
      }
      commonTest {
         dependencies {
            implementation( "org.jetbrains.kotlin:kotlin-test-common")
             implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
         }
      }
    }
}

tasks.register("copyFramework") {
    val buildType = project.findProperty("kotlin.build.type") as? String ?: "DEBUG"
    dependsOn("link${buildType.toLowerCase().capitalize()}FrameworkIos")

    doLast {
        val srcFile = (kotlin.targets.named("ios") as KotlinNativeTarget).binaries.getFramework(buildType).outputFile
        val targetDir = project.property("configuration.build.dir")!!
        copy {
            from(srcFile.parent)
            into(targetDir)
            include( "greeting.framework/**")
            include("greeting.framework.dSYM")
        }
    }
}

tasks.register("iosTest")  {
    val  device = project.findProperty("iosDevice") as? String ?: "iPhone 8"
    dependsOn("linkDebugTestIos")
    group = JavaBasePlugin.VERIFICATION_GROUP
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        val  binary = (kotlin.targets.named("ios") as KotlinNativeTarget).binaries.getTest("DEBUG").outputFile
        exec {
            commandLine("xcrun", "simctl", "spawn", "--standalone", device, binary.absolutePath)
        }
    }
}
