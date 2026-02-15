/*
Factory Pattern

Definition:
Factory Pattern hides object creation and reduces tight coupling between 
client and concrete classes.

Factory Pattern strongly supports the D of SOLID (Dependency Inversion Principle).


Client should NOT do:
    new Car()

Instead:
    factory.createVehicle()
*/


// ==============================
// Product interface
// ==============================
interface Vehicle {
    void drive();
}


// ==============================
// Concrete products
// ==============================
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving Car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Driving Bike");
    }
}

class Truck implements Vehicle {
    public void drive() {
        System.out.println("Driving Truck");
    }
}


// ==============================
// Factory class
// ==============================
class VehicleFactory {

    public static Vehicle createVehicle(String type) {

        if (type.equalsIgnoreCase("car")) {
            return new Car();
        }
        else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        else if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        }
        else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}


// ==============================
// Client (Main)
// ==============================
public class FactoryPattern {

    public static void main(String[] args) {

        Vehicle v1 = VehicleFactory.createVehicle("car");
        v1.drive();

        Vehicle v2 = VehicleFactory.createVehicle("bike");
        v2.drive();

        Vehicle v3 = VehicleFactory.createVehicle("truck");
        v3.drive();
    }
}
