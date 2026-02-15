/*
    ADAPTER DESIGN PATTERN
    Adapter Design Pattern is a structural pattern that acts as a bridge between
    two incompatible interfaces, allowing them to work together.
    It is especially useful for integrating legacy code or third-party libraries
    into a new system.

    Components:
    1. Target    -> interface client expects
    2. Adaptee   -> existing incompatible class
    3. Adapter   -> converts interface
    4. Client    -> uses Target only

Target Interface: The interface expected by the client, defining the operations it can use.
Adaptee: The existing class with an incompatible interface that needs integration.
Adapter: Implements the target interface and uses the adaptee internally, acting as a bridge.
Client: Uses the target interface, unaware of the adapter or adaptee details.
*/




// ===============================
// 1️⃣ TARGET INTERFACE
// Client expects this
// ===============================
interface Target {

    void request();   // expected method
}



// ===============================
// 2️⃣ ADAPTEE
// Existing/legacy class
// Has useful logic BUT incompatible method name
// ===============================
class Adaptee {

    public void specificRequest() {
        System.out.println("Specific request from Adaptee");
    }
}



// ===============================
// 3️⃣ ADAPTER
// Implements Target
// Wraps Adaptee (composition)
// Converts request() -> specificRequest()
// ===============================
class Adapter implements Target {

    private Adaptee adaptee;   // HAS-A relationship

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {

        // translate call
        adaptee.specificRequest();
    }
}



// ===============================
// 4️⃣ CLIENT
// Talks ONLY to Target
// Doesn't know about Adaptee
// ===============================
public class AdapterPattern {

    public static void main(String[] args) {

        // create adaptee
        Adaptee adaptee = new Adaptee();

        // wrap with adapter
        Target target = new Adapter(adaptee);

        // client calls target
        target.request();
    }
}
