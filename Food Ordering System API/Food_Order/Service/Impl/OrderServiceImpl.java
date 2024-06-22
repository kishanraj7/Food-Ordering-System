package Food_Order.Service.Impl;

import Food_Order.Models.FoodItem;
import Food_Order.Models.Order;
import Food_Order.Repositories.Impl.OrderRepoImpl;
import Food_Order.Repositories.Impl.foodItemRepoImpl;
import Food_Order.Service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRepoImpl orderRepo = new OrderRepoImpl();
    foodItemRepoImpl foodItems = new foodItemRepoImpl();
    @Override
    public void placeOrder(Order order) {
        orderRepo.saveOrder(order);
        System.out.println("Order Placed SuccessFully");
    }
    public double calculateTotalPrice() {
        Order order = null;
        double total = 0;
        List<FoodItem> ItemList = foodItems.getList();
        if (order.getFoodItems().equals(ItemList)) {
            for (FoodItem item : ItemList) {
                total += item.getPrice();
            }
            order.setTotalPrice(total);
        }
        return order.getTotalPrice();
    }

    @Override
    public void getOrdersByCustomerId(String customerId) {
        List<Order> orders = orderRepo.getList();
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId)) {
                System.out.println("Order ID: " + order.getId());
                System.out.println("Food Items Ordered: " + order.getFoodItems());
                System.out.println("Restaurant ID: " + order.getRestaurantId());
                System.out.println("Grand Total: " + calculateTotalPrice());
                System.out.println("Order Status: " + order.getStatus());
                System.out.println("-------------------------------------");
            } else {
                System.out.println("No Orders Found for this Customer ID");
            }
        }
    }

    @Override
    public void getOrdersByRestaurantId(String restaurantId) {
        List<Order> orders = orderRepo.getList();
        for (Order order : orders) {
            if (order.getRestaurantId().equals(restaurantId)) {
                System.out.println("Order ID: " + order.getId());
                System.out.println("Customer ID: " + order.getCustomerId());
                System.out.println("Food Items Ordered: " + order.getFoodItems());
                System.out.println("Grand Total: " + order.getTotalPrice());
                System.out.println("Order Status: " + order.getStatus());
                System.out.println("---------------------------");
            }
            else {
                System.out.println("No Orders Found For This Restaurant ID");
            }
        }
    }

    @Override
    public void updateOrderStatus(String orderId, String status) {
            orderRepo.updateOrder(orderId, status);
        }
}
