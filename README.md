# Multiplatform sample
This example shows how to use Kotlin/Native in the multiplatform world.

This sample based on the [multiplatform documentation](https://github.com/JetBrains/kotlin-native/blob/master/MULTIPLATFORM.md).
If you have questions about the structure or how it works take a look at the documenation there.

## Greeting
The generated **Greeting classes** will be used in unit tests.

See [here](androidApp/app/src/test/kotlin/org/konan/multiplatform/GreetingTest.kt) for Android and [here](iosApp/iosAppTests/iosAppTests.swift) for iOS.

## iOS

 To compile application and run tests from the command line

```
  > cd iosApp
  > ../gradlew -p ../greeting/ios build
  > ../gradlew -p ../greeting/ios test
```

 and for Xcode just open `iosApp/iosApp.xcodeproj` and run application.

 ## Android

 To compile application and run tests from the command line

```
   > cd androidApp
   > ../gradlew build
   > ../gradlew test
   > cd ../greeting/android
   > ../../gradlew test
```