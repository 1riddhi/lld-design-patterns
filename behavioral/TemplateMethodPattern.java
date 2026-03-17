// Template Method Pattern defines the overall structure of an algorithm
//  in a base class and allows subclasses to override specific steps without changing the algorithm’s flow.


// when you want all classes to follow the specific steps 
// but also need to provide the flexibility that each class can have
// their own logic in that specific steps.


// ABSTRACT CLASS (Template)
abstract class Beverage {

    // Template Method (final so subclasses can't change flow)
    public final void prepareRecipe() {

        boilWater();
        brew();            // different
        pourInCup();
        addCondiments();   // different
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps that subclasses must implement
    protected abstract void brew();
    protected abstract void addCondiments();
}


// ---------------- TEA ----------------
class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Steeping tea leaves");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}


// ---------------- COFFEE ----------------
class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Brewing coffee grounds");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}


// ---------------- MAIN ----------------
public class TemplateMethodPattern {

    public static void main(String[] args) {

        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("----------------");

        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
