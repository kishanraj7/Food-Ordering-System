package Food_Order.Service;

import Food_Order.Models.Resturant;

public interface ResturantService {
    void createRestaurant(Resturant resturant);
    void updateResturant(String restaurantId, Resturant restaurant);
    void deleteResturant(String restaurantId);
    void getResturantsByOwnerId(String ownerId);
}
