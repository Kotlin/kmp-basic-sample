[![official project](http://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)

# Kotlin Multiplatform Sample

This is a **Kotlin Multiplatform (KMP) Project**. It includes iOS and Android applications with a native UI and a module with code shared on iOS and Android.

## Features

This sample demonstrates basic KMP features:
* Using platform-specific APIs with the expect/actual mechanism (see `Platform.kt`)
* Tests for Shared Module (see `CalculatorTest.kt`, `iosTest.kt`, `androidTest.kt`)

## How to use

With the [KMP plugin for Android Studio](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) you can run, test, and debug shared code on both platforms without switching IDEs. Run and debug the application by selecting the corresponding configuration in the **Run configuration** menu. Run and debug shared module tests by pressing the gutter icon on a test class or method.

## Related links

* Visit [Kotlin Multiplatform Developer Portal](https://kotlinlang.org/lp/mobile/) to learn more about the technology
* Check out the [Networking and data storage with KMP hands-on](https://play.kotlinlang.org/hands-on/Networking%20and%20Data%20Storage%20with%20Kotlin%20Multiplatfrom%20Mobile/) lab to learn how to create a mobile application for Android and iOS with a shared codebase with Ktor and SQLDelight.




