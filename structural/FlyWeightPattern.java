import java.util.*;

// =============================
// 1. Flyweight (Shared Object)
// =============================
class CarType {

    private final String brand;   // intrinsic (shared)
    private final String model;   // intrinsic (shared)
    private final String color;   // intrinsic (shared)

    public CarType(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        System.out.println("Creating CarType: " + brand + " " + model + " " + color);
    }

    public void display(String carNumber, String location) {
        System.out.println(
                "CarNumber: " + carNumber +
                ", Location: " + location +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Color: " + color
        );
    }
}

// =============================
// 2. Flyweight Factory
// =============================
class CarFactory {

    private static final Map<String, CarType> carTypes = new HashMap<>();

    public static CarType getCarType(String brand, String model, String color) {

        String key = brand + "-" + model + "-" + color;

        if (!carTypes.containsKey(key)) {
            carTypes.put(key, new CarType(brand, model, color));
        }

        return carTypes.get(key);
    }

    public static int totalTypesCreated() {
        return carTypes.size();
    }
}

// =============================
// 3. Context Object (Unique)
// =============================
class Car {

    private final String carNumber;  // extrinsic (unique)
    private final String location;   // extrinsic (unique)
    private final CarType type;      // shared reference

    public Car(String carNumber, String location, CarType type) {
        this.carNumber = carNumber;
        this.location = location;
        this.type = type;
    }

    public void showDetails() {
        type.display(carNumber, location);
    }
}

// =============================
// 4. Client
// =============================
public class FlyweightDemo {

    public static void main(String[] args) {

        // Shared Flyweight
        CarType bmwBlack = CarFactory.getCarType("BMW", "M5", "Black");

        // Many cars using same shared object
        Car car1 = new Car("KA01AB1234", "Delhi", bmwBlack);
        Car car2 = new Car("KA02CD5678", "Mumbai", bmwBlack);
        Car car3 = new Car("KA03EF9999", "Chennai", bmwBlack);

        car1.showDetails();
        car2.showDetails();
        car3.showDetails();

        System.out.println("\nTotal CarType objects created: "
                + CarFactory.totalTypesCreated());
    }
}
