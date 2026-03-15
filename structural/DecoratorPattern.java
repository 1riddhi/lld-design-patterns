// Decorator is a structural pattern that dynamically adds new behavior
// to an object by wrapping it without modifying its original code.

// When to use:
// When you need to add responsibilities (like logging, caching, validation, toppings, etc.) 
// to objects at runtime.

// Why to use:
// To extend behavior without changing existing classes
//  and to follow the Open/Closed Principle.


//diff btw builder and decorator
//(we canNot modify (add param /remove param of class) in builder
// but in decorator we can wrap/unwrap the object object at runtime)

// ======================
// 1. Component Interface
// ======================
interface Pizza {
    int getCost();
    String getDescription();
}

// ======================
// 2. Concrete Component
// ======================
class BasicPizza implements Pizza {

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }
}

// ======================
// 3. Base Decorator
// ======================
abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    // Method to unwrap inner object
    public Pizza unwrap() {
        return pizza;
    }

}

// ======================
// 4. Concrete Decorators
// ======================
class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 50;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
}

class OlivesDecorator extends PizzaDecorator {

    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
}

class PaneerDecorator extends PizzaDecorator {

    public PaneerDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 70;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Paneer";
    }
}

// ======================
// 5. Client Code
// ======================
public class DecoratorPattern {

    public static void main(String[] args) {

        // Step 1: Start with basic pizza
        Pizza pizza = new BasicPizza();

        // Step 2: Add cheese
        pizza = new CheeseDecorator(pizza);

        // Step 3: Add olives
        pizza = new OlivesDecorator(pizza);

        // Step 4: Add paneer
        pizza = new PaneerDecorator(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: ₹" + pizza.getCost());

         //Unwrap last decorator (Paneer)
        if (pizza instanceof PizzaDecorator) {
            pizza = ((PizzaDecorator) pizza).unwrap();
        }

        System.out.println("\nAfter unwrap:");
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: ₹" + pizza.getCost());

    }
}
