//The Facade Design Pattern is a structural pattern that provides a simple,
//  unified interface to a complex subsystem(group of classed)

interface Hotel {
    void getMenu();
}

// ==========================
// 2️⃣ Concrete Hotels
// ==========================
class VegRestaurant implements Hotel {

    @Override
    public void getMenu() {
        System.out.println("Veg Menu: Paneer, Dal, Roti, Rice");
    }
}

class NonVegRestaurant implements Hotel {

    @Override
    public void getMenu() {
        System.out.println("Non-Veg Menu: Chicken, Mutton, Fish");
    }
}

class BothRestaurant implements Hotel {

    @Override
    public void getMenu() {
        System.out.println("Veg & Non-Veg Menu: Paneer, Chicken, Fish, Dal");
    }
}

// ==========================
// 3️⃣ Facade Interface
// ==========================
interface HotelKeeper {

    Hotel getVegMenu();
    Hotel getNonVegMenu();
    Hotel getVegNonMenu();
}

// ==========================
// 4️⃣ Facade Implementation
// ==========================
class HotelKeeperImpl implements HotelKeeper {

    @Override
    public Hotel getVegMenu() {
        return new VegRestaurant();
    }

    @Override
    public Hotel getNonVegMenu() {
        return new NonVegRestaurant();
    }

    @Override
    public Hotel getVegNonMenu() {
        return new BothRestaurant();
    }
}

// ==========================
// 5️⃣ Client
// ==========================
public class FacadePattern {

    public static void main(String[] args) {

        HotelKeeper keeper = new HotelKeeperImpl();

        Hotel vegMenu = keeper.getVegMenu();
        vegMenu.getMenu();

        Hotel nonVegMenu = keeper.getNonVegMenu();
        nonVegMenu.getMenu();

        Hotel bothMenu = keeper.getVegNonMenu();
        bothMenu.getMenu();
    }
}
