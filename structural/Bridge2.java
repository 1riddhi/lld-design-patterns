public class Bridge2 {

    /* =====================================================
       IMPLEMENTOR HIERARCHY
       This side defines the implementation (Color)
       ===================================================== */

    interface Color {
        void applyColor();
    }

    static class Red implements Color {
        public void applyColor() {
            System.out.println("Red color applied");
        }
    }

    static class Blue implements Color {
        public void applyColor() {
            System.out.println("Blue color applied");
        }
    }



    /* =====================================================
       ABSTRACTION HIERARCHY
       Shapes use Color but do not know its implementation
       ===================================================== */

    static abstract class Shape {

        // ⭐⭐⭐ THIS IS THE BRIDGE ⭐⭐⭐
        // Shape is connected to Color using composition
        protected Color color;

        Shape(Color color) {
            this.color = color;
        }

        abstract void draw();
    }



    /* =====================================================
       REFINED ABSTRACTIONS
       ===================================================== */

    static class Circle extends Shape {

        Circle(Color color) {
            super(color);
        }

        void draw() {
            System.out.print("Drawing Circle with ");
            color.applyColor();
        }
    }

    static class Square extends Shape {

        Square(Color color) {
            super(color);
        }

        void draw() {
            System.out.print("Drawing Square with ");
            color.applyColor();
        }
    }



    /* =====================================================
       MAIN
       ===================================================== */

    public static void main(String[] args) {

        Shape circle = new Circle(new Red());
        circle.draw();

        Shape square = new Square(new Blue());
        square.draw();
    }
}