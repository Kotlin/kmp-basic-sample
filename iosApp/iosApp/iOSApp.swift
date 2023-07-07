import SwiftUI

@main
struct SampleApp: App {

  init() {
        HelperKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
