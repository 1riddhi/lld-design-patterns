//The Facade Design Pattern is a structural pattern that provides a simple,
//  unified interface to a complex subsystem(group of classed)

// What:
// Facade provides a simple interface over a complex subsystem.

// Why:
// It hides subsystem complexity and reduces the client's dependency on multiple classes.

public class FacadePattern {

    public static void main(String[] args) {

        OrderFacade orderFacade = new OrderFacade();

        orderFacade.createOrder();
    }
}


// Subsystem 1
class ProductDAO {

    public Product getProduct(int productId) {
        System.out.println("Product fetched: " + productId);
        return new Product();
    }
}


// Subsystem 2
class Payment {

    public void makePayment() {
        System.out.println("Payment successful");
    }
}


// Subsystem 3
class Invoice {

    public void generateInvoice() {
        System.out.println("Invoice generated");
    }
}


// Subsystem 4
class SendNotification {

    public void sendNotification() {
        System.out.println("Notification sent");
    }
}


// Simple Product class
class Product {
}


// Facade
class OrderFacade {

    private final ProductDAO productDao;
    private final Invoice invoice;
    private final Payment payment;
    private final SendNotification notification;

    public OrderFacade() {
        productDao = new ProductDAO();
        invoice = new Invoice();
        payment = new Payment();
        notification = new SendNotification();
    }

    public void createOrder() {

        Product product = productDao.getProduct(121);
        payment.makePayment();
        invoice.generateInvoice();
        notification.sendNotification();
        System.out.println("Order creation successful");
    }
}