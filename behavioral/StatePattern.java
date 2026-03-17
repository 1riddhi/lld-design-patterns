// Instead of using if-else for state handling, I created separate state classes implementing a common interface.
// The context delegates behavior to the current state and allows dynamic state transitions.”
// 
// A behavioral design pattern that allows an object(context) to change its behavior when its internal state changes, by delegating state-specific behavior to separate state classes.
// 
// State Design Pattern - Vending Machine Example

// 1. State interface (defines actions)
interface State {
    void insertCoin(VendingMachine machine);
    void selectItem(VendingMachine machine);
}

// 2. Concrete State: No Coin
class NoCoinState implements State {

    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted");
        machine.setState(new HasCoinState()); // state transition
    }

    public void selectItem(VendingMachine machine) {
        System.out.println("Insert coin first");
    }
}

// 3. Concrete State: Has Coin
class HasCoinState implements State {

    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin already inserted");
    }

    public void selectItem(VendingMachine machine) {
        System.out.println("Item dispensed");
        machine.setState(new NoCoinState()); // state transition back
    }
}

// 4. Context class (delegates behavior to current state)
class VendingMachine {
    private State currentState;

    public VendingMachine() {
        currentState = new NoCoinState(); // initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin(this); // delegate to state
    }

    public void selectItem() {
        currentState.selectItem(this); // delegate to state
    }
}

// 5. Driver
public class StatePattern {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.selectItem();   // Insert coin first
        vm.insertCoin();   // Coin inserted
        vm.selectItem();   // Item dispensed
    }
}