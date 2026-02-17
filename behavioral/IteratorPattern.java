// Iterator is a behavioral design pattern that lets you traverse 
// elements of a collection without exposing its underlying representation (list, stack, tree, etc.).


//It allows us to loop through elements without knowing how they are stored (array, list, tree, etc.).

// Iterator Interface
interface MyIterator {
    boolean hasNext();
    String next();
}

// Collection Interface
interface MyCollection {
    MyIterator createIterator();
}


// Concrete Collection
class NameCollection implements MyCollection {

    private String[] names;

    public NameCollection(String[] names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    @Override
    public MyIterator createIterator() {
        //this → refers to collection object (collection object using which createIterator called)
        return new NameIterator(this);
    }
}


// Concrete Iterator (Separate Class)
class NameIterator implements MyIterator {

    private NameCollection collection;
    private int index = 0;

    public NameIterator(NameCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.getNames().length;
    }

    @Override
    public String next() {
        if (hasNext()) {
            return collection.getNames()[index++];
        }
        return null;
    }
}


// Main Class
public class IteratorPattern {

    public static void main(String[] args) {

        String[] names = {"Alice", "Bob", "Charlie"};

        NameCollection collection = new NameCollection(names);

        // Two iterators
        MyIterator it1 = collection.createIterator();
        MyIterator it2 = collection.createIterator();

        System.out.println(it1.next()); // Alice
        System.out.println(it1.next()); // Bob

        System.out.println(it2.next()); // Alice (starts fresh)
    }
}
