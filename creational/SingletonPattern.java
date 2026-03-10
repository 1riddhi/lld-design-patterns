/*
    Singleton Pattern Example
    Thread Safe + Lazy Initialization
*/

// Singleton ensures that only one object of a class is created and provides a global access point to it.

// ✅ In simple words

// 👉 “Only ONE instance allowed in whole application”

// ✅ Why we use it

// When exactly one shared resource is needed:

// Examples:
// Database connection
// Logger
// Config manager
// Cache
// Thread pool

// Because:

// saves memory
// avoids multiple conflicting objects
// shared state


// SingletonDemo.java
public class SingletonPattern {

    // -------------------------------
    // 1️⃣ Eager Initialization
    // -------------------------------
    static class SingletonEager {
        // Instance created at class loading
        private static final SingletonEager instance = new SingletonEager();

        private SingletonEager() {
            System.out.println("Eager Singleton instance created");
        }

        public static SingletonEager getInstance() {
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello from Eager Singleton!");
        }
    }

    // -------------------------------
    // 2️⃣ Double Checked Locking (DCL)
    // -------------------------------
    static class SingletonDCL {
        private static volatile SingletonDCL instance;

        private SingletonDCL() {
            System.out.println("DCL Singleton instance created");
        }

        public static SingletonDCL getInstance() {
            if (instance == null) {                 // First check (no lock)
                synchronized (SingletonDCL.class) {
                    if (instance == null) {         // Second check (with lock)
                        instance = new SingletonDCL();
                    }
                }
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello from DCL Singleton!");
        }
    }

    // -------------------------------
    // 3️⃣ Bill Pugh Singleton
    // -------------------------------
    static class SingletonBillPugh {

        private SingletonBillPugh() {
            System.out.println("Bill Pugh Singleton instance created");
        }

        // Holder class loaded only when getInstance() is called
        private static class Holder {
            private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
        }

        public static SingletonBillPugh getInstance() {
            return Holder.INSTANCE;
        }

        public void showMessage() {
            System.out.println("Hello from Bill Pugh Singleton!");
        }
    }

    // -------------------------------
    // Main method to test all
    // -------------------------------
    public static void main(String[] args) {

        System.out.println("=== Eager Singleton ===");
        SingletonEager e1 = SingletonEager.getInstance();
        SingletonEager e2 = SingletonEager.getInstance();
        e1.showMessage();
        System.out.println("Same instance? " + (e1 == e2));

        System.out.println("\n=== DCL Singleton ===");
        SingletonDCL d1 = SingletonDCL.getInstance();
        SingletonDCL d2 = SingletonDCL.getInstance();
        d1.showMessage();
        System.out.println("Same instance? " + (d1 == d2));

        System.out.println("\n=== Bill Pugh Singleton ===");
        SingletonBillPugh b1 = SingletonBillPugh.getInstance();
        SingletonBillPugh b2 = SingletonBillPugh.getInstance();
        b1.showMessage();
        System.out.println("Same instance? " + (b1 == b2));
    }
}
