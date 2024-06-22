package Food_Order.Repositories;

import Food_Order.Models.Resturant;

import java.util.List;

public interface ResturantRepo {
    List<Resturant> findByOwnerId(String ownerId);
    void saveResturant(Resturant resturant);
    Resturant findById(String id);
    void update(Resturant resturant);
    void deleteById(String id);
    List<Resturant> getList();
}
