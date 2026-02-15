/*
    ABSTRACT FACTORY PATTERN
    Vehicle Example
*/

// Abstract Factory creates families of related objects
// without exposing their concrete classes.

// A family means a group of compatible objects that are meant to work together, 
// like Car + CarEngine or Bike + BikeEngine.

//Concrete classes are hidden inside the factory,
// and the client works only with interfaces.

// ==============================
// Product Interfaces
// ==============================

interface Vehicle {
    void drive();
}

interface Engine {
    void start();
}


// ==============================
// Car Family
// ==============================

class Car implements Vehicle {
    public void drive() {
        System.out.println("Car driving");
    }
}

class CarEngine implements Engine {
    public void start() {
        System.out.println("Car engine started");
    }
}


// ==============================
// Bike Family
// ==============================

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Bike riding");
    }
}

class BikeEngine implements Engine {
    public void start() {
        System.out.println("Bike engine started");
    }
}


// ==============================
// Abstract Factory
// ==============================

interface VehicleFactory {

    Vehicle createVehicle();

    Engine createEngine();
}


// ==============================
// Concrete Factories
// Each creates MATCHING family
// ==============================

class CarFactory implements VehicleFactory {

    public Vehicle createVehicle() {
        return new Car();
    }

    public Engine createEngine() {
        return new CarEngine();
    }
}

class BikeFactory implements VehicleFactory {

    public Vehicle createVehicle() {
        return new Bike();
    }

    public Engine createEngine() {
        return new BikeEngine();
    }
}


// ==============================
// Client
// ==============================

public class AbstractFactoryPattern {

    public static void main(String[] args) {

        // choose ONE factory only
        VehicleFactory factory = new CarFactory();
        // try new BikeFactory();

        Vehicle vehicle = factory.createVehicle();
        Engine engine = factory.createEngine();

        engine.start();
        vehicle.drive();
    }
}
