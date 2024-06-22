package Food_Order.Controllers;

import Food_Order.Models.Resturant;
import Food_Order.Service.Impl.ResturantServiceImpl;

public class ResturentController {
    ResturantServiceImpl resturantService = new ResturantServiceImpl();
    public void createResturant(Resturant r){
        resturantService.createRestaurant(r);
    }
    public void updateResturant(String resId, Resturant r){
        resturantService.updateResturant(resId,r);
    }
    public void deleteResturant(String Rid){
        resturantService.deleteResturant(Rid);
    }
    public void getRestroByOwnerId(String OwnId){
        resturantService.getResturantsByOwnerId(OwnId);
    }
}
