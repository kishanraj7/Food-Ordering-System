package Food_Order.Controllers;

import Food_Order.Models.FoodItem;
import Food_Order.Service.Impl.foodItemServiceImpl;

public class foodItemController {
    foodItemServiceImpl foodItemService=new foodItemServiceImpl();
    public void addItem(String resid, FoodItem foodItem){
        foodItemService.addFoodItem(resid,foodItem);
    }
    public void updateItem(String fid,FoodItem foodItem){
        foodItemService.updateFoodItem(fid,foodItem);
    }
    public void deleteItem(String Fid){
        foodItemService.deleteFoodItem(Fid);
    }
    //To Resturant And Customer
    public void loadMenu(String resId){
        foodItemService.getFoodItemsByRestaurantId(resId);
    }

}
