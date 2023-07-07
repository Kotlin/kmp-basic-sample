package com.jetbrains.kmm.shared

actual class Platform actual constructor() {
    //without DI
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT} without DI"

    // With DI
    actual val newVal = "from Android using DI!"
}