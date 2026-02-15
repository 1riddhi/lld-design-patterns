//State pattern allows an object to change its behavior when its internal state changes.
// The object will appear to change its class.

// Behavior Interface (instead of State)
interface SignalBehavior {
    void next(TrafficLight light);
    void display();
}


// ---------------- RED ----------------
class RedSignal implements SignalBehavior {

    public void next(TrafficLight light) {
        light.setBehavior(new GreenSignal());
    }

    public void display() {
        System.out.println("RED - Stop");
    }
}


// ---------------- GREEN ----------------
class GreenSignal implements SignalBehavior {

    public void next(TrafficLight light) {
        light.setBehavior(new YellowSignal());
    }

    public void display() {
        System.out.println("GREEN - Go");
    }
}


// ---------------- YELLOW ----------------
class YellowSignal implements SignalBehavior {

    public void next(TrafficLight light) {
        light.setBehavior(new RedSignal());
    }

    public void display() {
        System.out.println("YELLOW - Wait");
    }
}


// ---------------- CONTEXT ----------------
class TrafficLight {

    private SignalBehavior behavior;

    public TrafficLight() {
        behavior = new RedSignal(); // initial behavior
    }

    public void setBehavior(SignalBehavior behavior) {
        this.behavior = behavior;
    }

    public void next() {
        behavior.next(this);
    }

    public void show() {
        behavior.display();
    }
}


// ---------------- MAIN ----------------
public class StatePattern {
    public static void main(String[] args) {

        TrafficLight light = new TrafficLight();

        light.show();
        light.next();

        light.show();
        light.next();

        light.show();
        light.next();

        light.show();
    }
}
