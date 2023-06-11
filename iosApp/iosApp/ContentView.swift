import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewModel: CalendarViewModel = KmmViewModel(viewModel: ScaleSDK.shared.getCalendarViewModel())
    
    var body: some View {
        VStack {
            CalendarView(viewModel: viewModel)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
