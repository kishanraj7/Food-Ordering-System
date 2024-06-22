package Food_Order.Repositories.Impl;

import Food_Order.Models.FoodItem;
import Food_Order.Models.Resturant;
import Food_Order.Repositories.foodItemsRepo;

import java.util.ArrayList;
import java.util.List;

public class foodItemRepoImpl implements foodItemsRepo {
    private List<FoodItem> foodItemList = new ArrayList<>();
    ResturantRepoImpl resturantRepo=new ResturantRepoImpl();

    @Override
    public void findByResturantId(String resturantId) {
        resturantRepo.findById(resturantId);
    }
    // Saving
    public void saveItem(FoodItem foodItem) {
        foodItemList.add(foodItem);
    }
    // Getting The List
    public List<FoodItem> getList() {
        return  foodItemList;
    }
    public void deleteById(String id) {
        foodItemList.removeIf(foodItem -> foodItem.getId().equals(id));
    }
    public FoodItem findByFoodId(String id) {
        for (FoodItem foodItem : foodItemList) {
            if (foodItem.getId().equals(id)) {
                return foodItem;
            }
        }
        return null;
    }
    public void update(FoodItem f) {
        int index = -1;
        for (int i = 0; i < foodItemList.size(); i++) {
            if (foodItemList.get(i).getId().equals(f.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            foodItemList.set(index, f);
        }
    }


}
