package Food_Order.Service.Impl;

import Food_Order.Models.FoodItem;
import Food_Order.Repositories.Impl.foodItemRepoImpl;
import Food_Order.Service.foodItemService;

import java.util.List;

public class foodItemServiceImpl implements foodItemService {
    foodItemRepoImpl foodItemRepo=new foodItemRepoImpl();
    @Override
    public void addFoodItem(String restaurantId, FoodItem foodItem) {
        if (foodItem == null) {
            throw new IllegalArgumentException("Food item cannot be null");
        }
        if (foodItem.getName() == null || foodItem.getName().isEmpty()) {
            throw new IllegalArgumentException("Food item name cannot be null or empty");
        }
        if (foodItem.getPrice() <= 0) {
            throw new IllegalArgumentException("Price cannot be Zero Or Negative");
        }
        foodItemRepo.saveItem(foodItem);
        System.out.println("Item Added To Your Menu");
    }

    @Override
    public void updateFoodItem(String foodItemId, FoodItem foodItem) {
        if (foodItemId == null || foodItemId.isEmpty()) {
            throw new IllegalArgumentException("Food item ID cannot be null or empty");
        }
        if (foodItem == null) {
            throw new IllegalArgumentException("Food item cannot be null");
        }
        FoodItem existingItem = foodItemRepo.findByFoodId(foodItemId);
        if (existingItem != null) {
            existingItem.setName(foodItem.getName());
            existingItem.setDescription(foodItem.getDescription());
            existingItem.setPrice(foodItem.getPrice());
            if (foodItem.getPrice() <= 0) {
                throw new IllegalArgumentException("Price cannot be Zero Or negative");
            }
            existingItem.setAvailability(foodItem.isAvailability());
            foodItemRepo.update(existingItem); //Update Items In Repo
            System.out.println("Menu Item Updated Successfully");
        } else {
            System.out.println("Food Item Not Found");
        }
    }

    @Override
    public void deleteFoodItem(String foodItemId) {
        if (foodItemId == null || foodItemId.isEmpty()) {
            throw new IllegalArgumentException("Food item ID cannot be null or empty");
        }
        if (foodItemRepo.findByFoodId(foodItemId) != null) {
            foodItemRepo.deleteById(foodItemId);
            System.out.println("Food Item Deletion Successfully");
        } else {
            System.out.println("Food Item Not Found");
        }
    }

    @Override
    public void getFoodItemsByRestaurantId(String restaurantId) {
        if (restaurantId == null || restaurantId.isEmpty()) {
            throw new IllegalArgumentException("Restaurant ID cannot be null or empty");
        }
        List<FoodItem> foodItemList = foodItemRepo.getList();
        for (FoodItem foodItem : foodItemList) {
            if (foodItem.getRestaurantId().equals(restaurantId)) {
                System.out.println("Food Item ID: " + foodItem.getId());
                System.out.println("Food Item Name: " + foodItem.getName());
                System.out.println("Description: " + foodItem.getDescription());
                System.out.println("Price: " + foodItem.getPrice());
                System.out.println("Availability: " + (foodItem.isAvailability() ? "Available" : "Not Available"));
                System.out.println("\n");
            } else {
                System.out.println("The Resturant ID Entered Is In Correct");
            }
        }

    }


}
