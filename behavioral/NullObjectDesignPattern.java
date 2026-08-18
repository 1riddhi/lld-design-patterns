// Null Object is a Behavioral Design Pattern because it defines the behavior of a "do nothing" object.

// What:
// Null Object Pattern provides a do-nothing object instead of null.

// Why:
// To avoid null checks and NullPointerException and keep the client code simple.

// 1. Common interface
interface Notification {
    void send(String message);
}

// 2. Real object
class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

// 3. Null Object
// Instead of returning null, we return this object.
// It safely does nothing.
class NullNotification implements Notification {

    @Override
    public void send(String message) {
        // Do nothing
    }
}

// 4. Factory
class NotificationFactory {

    public static Notification getNotification(String type) {

        if ("EMAIL".equals(type)) {
            return new EmailNotification();
        }

        // Instead of returning null
        return new NullNotification();
    }
}

// 5. Client
public class NullObjectDesignPattern{

    public static void main(String[] args) {

        Notification notification =
                NotificationFactory.getNotification("SMS");

        // No null check required
        notification.send("Hello");
    }
}