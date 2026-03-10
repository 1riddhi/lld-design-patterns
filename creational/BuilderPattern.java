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

class Vehicle {

    private String engine;
    private int seats;
    private boolean gps;

    // private constructor
    private Vehicle(Builder builder) {
        this.engine = builder.engine;
        this.seats = builder.seats;
        this.gps = builder.gps;
    }

    public void show() {
        System.out.println(
            "Engine: " + engine +
            ", Seats: " + seats +
            ", GPS: " + gps
        );
    }


    // ==========================
    // Builder
    // ==========================
    public static class Builder {

        private String engine;
        private int seats;
        private boolean gps;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this; // chaining
        }

        public Builder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder setGPS(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}


// ==========================
// Client
// ==========================

public class BuilderPattern {

    public static void main(String[] args) {

        Vehicle car = new Vehicle.Builder()
                .setEngine("V8")
                .setSeats(4)
                .setGPS(true)
                .build();

        car.show();
    }
}
