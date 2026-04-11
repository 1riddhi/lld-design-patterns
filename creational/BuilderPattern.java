//Builder pattern is used to construct complex objects step-by-step,
// especially when there are many optional parameters,
//improving readability and flexibility.

/*
    Builder Pattern WITHOUT Director
    Vehicle Example (Simple + Realistic)
*/

//builder builds vehicle object step by step -> composition relationship
//builder is a static nested class

//  Use the Builder pattern when you want your code to be
//  able to create different representations of some product (

// ==========================
// Product
// ==========================
class Vehicle {
    String engine;
    int seats;
    boolean gps;

    public void show() {
        System.out.println(
            "Engine: " + engine +
            ", Seats: " + seats +
            ", GPS: " + gps
        );
    }
}


// ==========================
// Builder Interface
// ==========================
interface VehicleBuilder {
    void setEngine(String engine);
    void setSeats(int seats);
    void setGPS(boolean gps);
    Vehicle getVehicle();
}


// ==========================
// Concrete Builder
// ==========================
class CarBuilder implements VehicleBuilder {

    private Vehicle vehicle;

    public CarBuilder() {
        this.vehicle = new Vehicle();
    }

    public void setEngine(String engine) {
        vehicle.engine = engine;
    }

    public void setSeats(int seats) {
        vehicle.seats = seats;
    }

    public void setGPS(boolean gps) {
        vehicle.gps = gps;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}


// ==========================
// Director
// ==========================
class Director {

    // Predefined configuration
    public void buildSportsCar(VehicleBuilder builder) {
        builder.setEngine("V8");
        builder.setSeats(2);
        builder.setGPS(true);
    }

    public void buildFamilyCar(VehicleBuilder builder) {
        builder.setEngine("V6");
        builder.setSeats(5);
        builder.setGPS(true);
    }
}


// ==========================
// Client
// ==========================
public class BuilderPattern {

    public static void main(String[] args) {

        Director director = new Director();

        // Build Sports Car
        VehicleBuilder builder1 = new CarBuilder();
        director.buildSportsCar(builder1);
        Vehicle sportsCar = builder1.getVehicle();
        sportsCar.show();

        // Build Family Car
        VehicleBuilder builder2 = new CarBuilder();
        director.buildFamilyCar(builder2);
        Vehicle familyCar = builder2.getVehicle();
        familyCar.show();
    }
}