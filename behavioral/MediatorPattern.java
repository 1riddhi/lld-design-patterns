// Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects.
// The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.

import java.util.ArrayList;
import java.util.List;

// 1️⃣ Mediator Interface
interface AirTrafficControl {
    void registerPlane(Plane plane);
    void sendMessage(String message, Plane sender);
}

// 2️⃣ Concrete Mediator
class ATC implements AirTrafficControl {

    private List<Plane> planes = new ArrayList<>();

    @Override
    public void registerPlane(Plane plane) {
        planes.add(plane);
    }

    @Override
    public void sendMessage(String message, Plane sender) {
        for (Plane plane : planes) {
            if (plane != sender) {
                plane.receive(message);
            }
        }
    }
}

// 3️⃣ Colleague Class
class Plane {

    private AirTrafficControl atc;
    private String name;

    public Plane(AirTrafficControl atc, String name) {
        this.atc = atc;
        this.name = name;
        atc.registerPlane(this);
    }

    public void send(String message) {
        System.out.println(name + " sending: " + message);
        atc.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(name + " received: " + message);
    }
}

// 4️⃣ Client
public class MediatorPattern {
    public static void main(String[] args) {

        AirTrafficControl atc = new ATC();

        Plane plane1 = new Plane(atc, "Flight A");
        Plane plane2 = new Plane(atc, "Flight B");
        Plane plane3 = new Plane(atc, "Flight C");

        plane1.send("Requesting landing clearance");
    }
}
