// Visitor design pattern allows you to add new operations to a group of related classes without modifying their structures.

// Visitor is best used when the object structure is fixed, but new operations need to be added frequently.

// Object structure is stable (Rooms).
// Operations keep changing (Price, Maintenance, Tax, etc.).
// Instead of adding methods inside Room classes, we create Visitors.
// Rooms accept visitors.
// Visitor performs operation.

// 1️⃣ Element Interface
interface Room {
    void accept(RoomVisitor visitor);
}

// 2️⃣ Concrete Elements
class SingleRoom implements Room {
    int basePrice = 1000;

    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}

class DoubleRoom implements Room {
    int basePrice = 1800;

    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}

class DeluxeRoom implements Room {
    int basePrice = 3000;

    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}

// 3️⃣ Visitor Interface
interface RoomVisitor {
    void visit(SingleRoom room);
    void visit(DoubleRoom room);
    void visit(DeluxeRoom room);
}

// 4️⃣ Visitor 1 → Price Operation
class RoomPriceVisitor implements RoomVisitor {

    public void visit(SingleRoom room) {
        System.out.println("Single Room Price: " + room.basePrice);
    }

    public void visit(DoubleRoom room) {
        System.out.println("Double Room Price: " + room.basePrice);
    }

    public void visit(DeluxeRoom room) {
        System.out.println("Deluxe Room Price: " + room.basePrice);
    }
}

// 5️⃣ Visitor 2 → Maintenance Operation
class RoomMaintenanceVisitor implements RoomVisitor {

    public void visit(SingleRoom room) {
        System.out.println("Cleaning Single Room");
    }

    public void visit(DoubleRoom room) {
        System.out.println("Cleaning Double Room");
    }

    public void visit(DeluxeRoom room) {
        System.out.println("Cleaning Deluxe Room");
    }
}

// 6️⃣ Client
public class VisitorPattern {

    public static void main(String[] args) {

        Room[] rooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new DeluxeRoom()
        };

        RoomVisitor priceVisitor = new RoomPriceVisitor();
        RoomVisitor maintenanceVisitor = new RoomMaintenanceVisitor();

        for (Room room : rooms) {
            room.accept(priceVisitor);
            room.accept(maintenanceVisitor);
            System.out.println("-----");
        }
    }
}
