package Food_Order.Service.Impl;

import Food_Order.Models.Resturant;
import Food_Order.Repositories.Impl.ResturantRepoImpl;
import Food_Order.Service.ResturantService;

import java.util.List;

public class ResturantServiceImpl implements ResturantService {
    ResturantRepoImpl resturantRepo = new ResturantRepoImpl();

    @Override
    public void createRestaurant(Resturant resturant) {
        resturantRepo.saveResturant(resturant);
        System.out.println("Restaurant Created Successfully");
    }

    @Override
    public void updateResturant(String restaurantId, Resturant restaurant) {
        Resturant existingResturant = resturantRepo.findById(restaurantId);
        if (existingResturant != null) {
            existingResturant.setName(restaurant.getName());
            existingResturant.setAdress(restaurant.getAdress());
            existingResturant.setPhone(restaurant.getPhone());
            existingResturant.setCusine(restaurant.getCusine());
            resturantRepo.update(existingResturant);
            System.out.println("Restaurant Updated Successfully");
        } else {
            System.out.println("Restaurant Not Found");
        }
    }

    @Override
    public void deleteResturant(String restaurantId) {
        if (resturantRepo.findById(restaurantId) != null) {
            resturantRepo.deleteById(restaurantId);
            System.out.println("Restaurant Deletion Successfully");
        } else {
            System.out.println("Restaurant Not Found");
        }
    }

    @Override
    public void getResturantsByOwnerId(String ownerId) {
        List<Resturant> resturants = resturantRepo.getList();
        for (Resturant resturant : resturants) {
            if(resturant.getOwnerId().equals(ownerId)) {
                System.out.println("Restaurant ID: " + resturant.getId());
                System.out.println("Restaurant Name: " + resturant.getName());
                System.out.println("Cusines: "+resturant.getCusine());
                System.out.println("Restaurant Location: " + resturant.getAdress());
                System.out.println("Restaurant Contact Number: " + resturant.getPhone());
                //System.out.println("Restaurant Menu: " + resturant.getFoodItems());
            }
            else {
                System.out.println("The Owner ID Entered Is In Correct");
            }
        }
    }

}
