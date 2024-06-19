package Food_Order.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private String restaurantId;
    private List foodItems = new ArrayList();
    private int totalPrice;
    private String status;
    //Constructor

    public Order(String id, String customerId, String restaurantId, List foodItems, int totalPrice, String status) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    // Getter & Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List foodItems) {
        this.foodItems = foodItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
