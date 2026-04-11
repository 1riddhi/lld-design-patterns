//Builder pattern is used to construct complex objects step-by-step,
// especially when there are many optional parameters,
//improving readability and flexibility.

 /*
-    Builder Pattern WITHOUT Director
-    Vehicle Example (Simple + Realistic)
-*/

//builder builds vehicle object step by step -> composition relationship
//builder is a static nested class

//  Use the Builder pattern when you want your code to be
//  able to create different representations of some product (

// ==========================
// Product
// ==========================
class Computer {

    private final String cpu;
    private final int ramGb;
    private final String storage;

    Computer(String cpu, int ramGb, String storage) {
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer{cpu='" + cpu + "', ramGb=" + ramGb + ", storage='" + storage + "'}";
    }
}

// ==============================
// Builder (interface + concrete)
// ==============================
interface ComputerBuilder {

    ComputerBuilder cpu(String cpu);

    ComputerBuilder ramGb(int ramGb);

    ComputerBuilder storage(String storage);

    Computer build();
}

class StandardComputerBuilder implements ComputerBuilder {

    private String cpu;
    private int ramGb;
    private String storage;

    @Override
    public ComputerBuilder cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder ramGb(int ramGb) {
        this.ramGb = ramGb;
        return this;
    }

    @Override
    public ComputerBuilder storage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(cpu, ramGb, storage);
    }
}

// ==============================
// Director — knows preset configurations; uses only ComputerBuilder
// ==============================
class ComputerDirector {

    private ComputerBuilder builder;

    ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    Computer buildOfficePc() {
        return builder
                .cpu("Intel i5")
                .ramGb(16)
                .storage("512GB SSD")
                .build();
    }

    Computer buildGamingPc() {
        return builder
                .cpu("AMD Ryzen 9")
                .ramGb(32)
                .storage("2TB NVMe")
                .build();
    }
}

// ==============================
// Client
// ==============================
public class BuilderPattern {

    public static void main(String[] args) {

        ComputerDirector director = new ComputerDirector(new StandardComputerBuilder());

        System.out.println("--- Director: presets ---");
        System.out.println(director.buildOfficePc());
        System.out.println(director.buildGamingPc());

        System.out.println("\n--- Client: custom build (no director) ---");
        Computer workstation = new StandardComputerBuilder()
                .cpu("Apple M3 Pro")
                .ramGb(36)
                .storage("1TB SSD")
                .build();
        System.out.println(workstation);
    }
}
