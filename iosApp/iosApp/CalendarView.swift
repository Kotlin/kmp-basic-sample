import SwiftUI
import Foundation
import shared

struct CalendarView: View {
    @ObservedObject var viewModel: CalendarViewModel
    @State private var monthOffset: Int = 0

    init(viewModel: CalendarViewModel) {
        self.viewModel = viewModel
    }

    var body: some View {
        GeometryReader { geometry in
            let squareSize = min(geometry.size.width, geometry.size.height) / 2
            VStack {
                HStack {
                    Button(action: {
                        withAnimation {
                            monthOffset -= 1
                            viewModel.event(event: .OnPreviousMonthClick())
                        }
                    }) {
                        Image(systemName: "arrow.left")
                    }
                    Spacer()
                    Text("\(viewModel.state.actualMonth) \(viewModel.state.actualYear)")
                        .font(.system(size: 24, weight: .bold, design: .default))
                    Spacer()
                    Button(action: {
                        withAnimation {
                            monthOffset += 1
                            viewModel.event(event: .OnNextMonthClick())
                        }
                    }) {
                        Image(systemName: "arrow.right")
                    }
                }
                .padding()
                dayOfWeekStack

                CalendarMonthView(monthOffset: monthOffset, viewModel: viewModel)
                    .gesture(
                        DragGesture(minimumDistance: squareSize / 2)
                            .onEnded { value in
                                if value.translation.width > 0 {
                                    withAnimation {
                                        monthOffset -= 1
                                        viewModel.event(event: .OnPreviousMonthClick())
                                    }
                                } else if value.translation.width < 0 {
                                    withAnimation {
                                        monthOffset += 1
                                        viewModel.event(event: .OnNextMonthClick())
                                    }
                                }
                            }
                    )
            }
            .frame(maxHeight: .infinity, alignment: .top)
        }
    }
}

var dayOfWeekStack: some View {
    HStack(spacing: 1) {
        Text("Dom").dayOfWeek()
        Text("Seg").dayOfWeek()
        Text("Ter").dayOfWeek()
        Text("Qua").dayOfWeek()
        Text("Qui").dayOfWeek()
        Text("Sex").dayOfWeek()
        Text("Sab").dayOfWeek()
    }
}


extension Text {
    func dayOfWeek() -> some View {
        self.frame(maxWidth: .infinity)
            .padding(.top, 1)
            .lineLimit(1)
    }
}

struct CalendarMonthView: View {
    let monthOffset: Int
    @ObservedObject var viewModel: CalendarViewModel
    @State private var selectedDay: MonthStruct?

    var body: some View {
        let calendar = Calendar.current
        let calendarMatrix = viewModel.state.calendarMatrix

        VStack(spacing: 0) {
            ForEach(0..<calendarMatrix.count, id: \.self) { index in
                HStack(spacing: 1) {
                let list = calendarMatrix[index]
                    ForEach(0..<list.count, id: \.self) { j in
                        VStack(spacing: 1){
                            DayDetail(day: list[j], selectedDay: $selectedDay){
                                self.selectedDay = list[j]
                            }
                        }
                    }
                }
            }
        }
    }
}

struct DayDetail: View{
    let day: MonthStruct
    var monthType: MonthType
    var dayType: DayType
    private var isToday: Bool
    @Binding var selectedDay: MonthStruct?
    var onTap: () -> Void
    
    init(day: MonthStruct, selectedDay: Binding<MonthStruct?>, onTap: @escaping () -> Void) {
        self.day = day
        self.monthType = day.monthType
        self.dayType = day.dayType
        self._selectedDay = selectedDay
        self.onTap = onTap
        self.isToday = dayType == DayType.today
    }
    
    var body: some View{
        ZStack{
            Circle()
                .fill(backgroundColor())
                .overlay(
                    Circle()
                        .stroke(Color.blue, lineWidth: isToday ? 1 : 0)
                )
            Text(String(day.time.dayOfMonth))
                .foregroundColor(textColor())
        }
        .onTapGesture {
            onTap()
        }
    }
    
    private func backgroundColor() -> Color{
        if (isSelected()){
            return Color.blue.opacity(backgroundOpacity())
        }else if(dayType == DayType.hasscale){
            return Color.orange.opacity(backgroundOpacity())
        }else{
            return Color.white.opacity(0.0)
        }
    }
    
    private func backgroundOpacity() -> Double{
        if (monthType == MonthType.previous || monthType == MonthType.next){
            return 0.3
        }else{
            return 0.9
        }
    }

    private func textColor() -> Color{
        if (monthType == MonthType.previous || monthType == MonthType.next){
            return Color.gray
        }else if (isSelected()){
            return Color.white
        }else{
            return Color.black
        }
    }
    
    private func isSelected() -> Bool{
        return selectedDay?.time.month == day.time.month && selectedDay?.time.year == day.time.year && selectedDay?.time.dayOfMonth == day.time.dayOfMonth
    }
}
