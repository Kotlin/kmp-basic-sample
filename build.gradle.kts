plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.1.2").apply(false)
    id("com.android.library").version("8.1.2").apply(false)
    kotlin("android").version("1.9.20-Beta2").apply(false)
    kotlin("multiplatform").version("1.9.20-Beta2").apply(false)
}