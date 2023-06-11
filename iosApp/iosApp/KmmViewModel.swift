import Combine
import shared

class KmmViewModel<STATE: AnyObject, EVENT: AnyObject, EFFECT: AnyObject, VM: EventChecker<STATE, EVENT, EFFECT>>: ObservableObject where VM: AnyObject  {
    typealias State = STATE
    typealias Event = EVENT
    typealias Effect = EFFECT
    
    @Published private(set) var state: State
    @Published private(set) var effect: Effect
    
    private let instance: VM
    
    init(viewModel: VM) {
        self.instance = viewModel
        self.state = viewModel.state.value!
        self.effect = viewModel.effect.value!
        subscribeToState()
        subscribeToEffect()
    }
    
    public func event(event: Event){
        instance.event(event: event)
    }
    
    private func subscribeToState() {
        let commonstate = instance.state
        commonstate.observe { [weak self] value in
            DispatchQueue.main.async {
                self?.state = value!
            }
        }
    }
    
    private func subscribeToEffect() {
        let commonEffect = instance.effect
        commonEffect.observe { [weak self] value in
            DispatchQueue.main.async {
                self?.effect = value!
            }
        }
    }
}
