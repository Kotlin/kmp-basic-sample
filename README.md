# Multiplatform sample
This example shows how to use Kotlin/Native in the multiplatform world.

This sample based on the [multiplatform documentation](https://github.com/h0tk3y/k-new-mpp-samples/blob/master/README.md).
If you have questions about the structure or how it works take a look at the documenation there.

## Greeting
The generated **Greeting classes** will be used in unit tests.

See [here](androidApp/app/src/test/kotlin/org/konan/multiplatform/GreetingTest.kt) for Android and [here](iosApp/iosAppTests/iosAppTests.swift) for iOS.

## iOS

 To compile application and run tests from the command line

```
  > cd iosApp
  > ../gradlew -p ../greeting build
  > ../gradlew -p ../greeting test
```

 and for Xcode just open `iosApp/iosApp.xcodeproj` and run application.
 If you are running application on the device, change Kotlin/Native target from preset.iosX64 to preset.arm64 [here](greeting/build.gradle)

 ## Android

 To compile application and run tests from the command line

```
   > ./gradlew :androidApp:build
```
