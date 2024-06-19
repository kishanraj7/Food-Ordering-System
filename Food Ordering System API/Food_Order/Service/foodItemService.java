package Food_Order.Service;

import Food_Order.Models.FoodItem;

public interface foodItemService {
    void addFoodItem(String restaurantId, FoodItem foodItem);
    void updateFoodItem(String foodItemId, FoodItem foodItem);
    void deleteFoodItem(String foodItemId);
    void getFoodItemsByRestaurantId(String restaurantId);
}
