// Prototype avoids expensive construction logic. Instead of building the object from scratch, it copies an already initialized object,
//  which is faster and simpler.

/*
    Prototype Pattern Example
    Vehicle cloning
*/

// We use the Prototype Design Pattern when object creation is expensive (e.g., involves DB/API calls, heavy computation, or complex setup). Instead of creating new objects repeatedly, we create one fully initialized object and then clone it. Cloning is faster because it avoids re-running the expensive initialization logic and only copies the existing state.


// =======================
// Prototype interface
// =======================

interface Prototype {
    Prototype clone();
}


// =======================
// Vehicle class
// =======================

class Vehicle implements Prototype {

    private String engine;
    private int seats;

    public Vehicle(String engine, int seats) {
        this.engine = engine;
        this.seats = seats;
    }

    // copy constructor (clone logic)
    public Vehicle(Vehicle other) {
        this.engine = other.engine;
        this.seats = other.seats;
    }

    @Override
    public Prototype clone() {
        return new Vehicle(this); // copy
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void show() {
        System.out.println("Engine: " + engine + ", Seats: " + seats);
    }
}


// =======================
// Client
// =======================

public class PrototypePattern {

    public static void main(String[] args) {

        // create first object
        Vehicle car1 = new Vehicle("V8", 4);

        // clone it
        Vehicle car2 = (Vehicle) car1.clone();

        // modify clone
        car2.setSeats(2);

        car1.show();
        car2.show();
    }
}
