/*
 * BUILDER PATTERN
 *
 * Separates the construction of a complex object from its representation so that
 * the same construction process can create different representations.
 *
 * Components (GoF):
 *   Product — the complex object being assembled (often immutable when built)
 *   Builder    — abstract interface for creating parts
 *   ConcreteBuilder — implements steps; tracks state; produces Product via build()
 *   Director   — defines recipes using only Builder steps (optional but idiomatic)
 *
 * Why use it:
 *   - Avoids telescoping constructors (many optional parameters)
 *   - Step-by-step construction with readable, fluent calls
 *   - Same construction algorithm, different builders → different products
 *
 * Related: Abstract Factory builds families; Builder focuses on assembling one
 * complex object step by step.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ==============================
// Product (immutable result)
// ==============================
final class Pizza {

    private final String dough;
    private final String sauce;
    private final List<String> toppings;

    Pizza(String dough, String sauce, List<String> toppings) {
        if (dough == null || dough.isBlank()) {
            throw new IllegalStateException("Dough is required");
        }
        this.dough = dough;
        this.sauce = sauce != null ? sauce : "none";
        this.toppings = Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza{dough='" + dough + "', sauce='" + sauce + "', toppings=" + toppings + "}";
    }
}

// ==============================
// Builder — abstraction for construction steps
// ==============================
interface PizzaBuilder {

    PizzaBuilder reset();

    PizzaBuilder dough(String dough);

    PizzaBuilder sauce(String sauce);

    PizzaBuilder addTopping(String topping);

    Pizza build();
}

// ==============================
// ConcreteBuilder — builds Pizza; fluent API
// ==============================
class GourmetPizzaBuilder implements PizzaBuilder {

    private String dough;
    private String sauce;
    private final List<String> toppings = new ArrayList<>();

    @Override
    public PizzaBuilder reset() {
        dough = null;
        sauce = null;
        toppings.clear();
        return this;
    }

    @Override
    public PizzaBuilder dough(String dough) {
        this.dough = dough;
        return this;
    }

    @Override
    public PizzaBuilder sauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    @Override
    public PizzaBuilder addTopping(String topping) {
        if (topping != null && !topping.isBlank()) {
            toppings.add(topping);
        }
        return this;
    }

    @Override
    public Pizza build() {
        Pizza pizza = new Pizza(dough, sauce, toppings);
        reset();
        return pizza;
    }
}

// ==============================
// Director — orchestrates construction without knowing concrete product details
// ==============================
class PizzaDirector {

    private PizzaBuilder builder;

    PizzaDirector(PizzaBuilder builder) {
        this.builder = builder;
    }

    void setBuilder(PizzaBuilder builder) {
        this.builder = builder;
    }

    /** Preset: same builder steps, fixed recipe */
    Pizza buildMargherita() {
        return builder
                .reset()
                .dough("thin Italian")
                .sauce("tomato basil")
                .addTopping("mozzarella")
                .addTopping("fresh basil")
                .build();
    }

    /** Another preset using the same construction process */
    Pizza buildPepperoniFeast() {
        return builder
                .reset()
                .dough("hand-tossed")
                .sauce("garlic tomato")
                .addTopping("mozzarella")
                .addTopping("pepperoni")
                .addTopping("parmesan")
                .build();
    }
}

// ==============================
// Client
// ==============================
public class BuilderPattern {

    public static void main(String[] args) {

        GourmetPizzaBuilder builder = new GourmetPizzaBuilder();
        PizzaDirector director = new PizzaDirector(builder);

        System.out.println("--- Director: preset recipes ---");
        System.out.println(director.buildMargherita());
        System.out.println(director.buildPepperoniFeast());

        System.out.println("\n--- Client: custom pizza via builder only (no director) ---");
        Pizza custom = new GourmetPizzaBuilder()
                .dough("deep dish")
                .sauce("creamy white")
                .addTopping("spinach")
                .addTopping("ricotta")
                .addTopping("mushrooms")
                .build();
        System.out.println(custom);

        System.out.println("\n--- Same director, new concrete builder (swap implementation) ---");
        PizzaDirector anotherDirector = new PizzaDirector(new GourmetPizzaBuilder());
        System.out.println(anotherDirector.buildMargherita());
    }
}
