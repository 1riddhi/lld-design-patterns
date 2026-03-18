// Template Method Pattern defines the overall structure of an algorithm
//  in a base class and allows subclasses to override specific steps without
//  changing the algorithm’s flow.


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





// Template Method Pattern - Payment Flow

abstract class PaymentFlow {

    // Template method (fixed flow)
    public final void sendMoney() {
        validate();
        debit();
        calculateFees();
        credit();
    }

    // Steps (to be customized by subclasses)
    abstract void validate();
    abstract void debit();
    abstract void calculateFees();
    abstract void credit();
}

// Concrete implementation 1
class UpiPayment extends PaymentFlow {

    void validate() {
        System.out.println("Validating UPI details");
    }

    void debit() {
        System.out.println("Debiting money via UPI");
    }

    void calculateFees() {
        System.out.println("No fees for UPI");
    }

    void credit() {
        System.out.println("Crediting receiver via UPI");
    }
}

// Concrete implementation 2
class CardPayment extends PaymentFlow {

    void validate() {
        System.out.println("Validating card details");
    }

    void debit() {
        System.out.println("Debiting money from card");
    }

    void calculateFees() {
        System.out.println("Applying 2% transaction fee");
    }

    void credit() {
        System.out.println("Crediting receiver account");
    }
}

// Driver
public class Main {
    public static void main(String[] args) {
        PaymentFlow payment1 = new UpiPayment();
        payment1.sendMoney();

        System.out.println("-----");

        PaymentFlow payment2 = new CardPayment();
        payment2.sendMoney();
    }
}
