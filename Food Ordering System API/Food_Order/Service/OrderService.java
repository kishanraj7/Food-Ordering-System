package Food_Order.Service;

import Food_Order.Models.Order;

public interface OrderService {

    void placeOrder(Order order);
    void getOrdersByCustomerId(String customerId);
    void getOrdersByRestaurantId(String restaurantId);
    void updateOrderStatus(String orderId, String status);
}
