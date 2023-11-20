package designPatterns.facadePattern;

class UserAuthentication {
    public void login(String username, String password) {
        System.out.println("User logged in");
    }
    public void logout() {
        System.out.println("User logged out");
    }
}

class PaymentProcessing {
    public void processPayment(String paymentMethod) {
        System.out.println("Payment processed");
    }
}

class InventoryManagement {
    public void updateInventory(String productId, int quantity) {
        System.out.println("Inventory updated");
    }
}

class OrderFulfillment {
    public void fulfillOrder(String orderId) {
        System.out.println("Order fulfilled");
    }
}

class ECommerceFacade {
    private UserAuthentication userAuthentication;
    private PaymentProcessing paymentProcessing;
    private InventoryManagement inventoryManagement;
    private OrderFulfillment orderFulfillment;

    public ECommerceFacade(UserAuthentication userAuthentication, PaymentProcessing paymentProcessing,
                           InventoryManagement inventoryManagement, OrderFulfillment orderFulfillment) {
        this.userAuthentication = userAuthentication;
        this.paymentProcessing = paymentProcessing;
        this.inventoryManagement = inventoryManagement;
        this.orderFulfillment = orderFulfillment;
    }

    public void purchaseProduct(String username, String password, String paymentMethod, String productId, int quantity) {
        userAuthentication.login(username, password);
        paymentProcessing.processPayment(paymentMethod);
        inventoryManagement.updateInventory(productId, quantity);
        orderFulfillment.fulfillOrder(productId);
        userAuthentication.logout();
    }
}

public class ECommerce {
   public static void main(String[] args) {
        ECommerceFacade eCommerceFacade = new ECommerceFacade(new UserAuthentication(), new PaymentProcessing(), new InventoryManagement(), new OrderFulfillment());
        eCommerceFacade.purchaseProduct("Dev", "123456", "Cash", "product_id_1", 5);
   }
}

