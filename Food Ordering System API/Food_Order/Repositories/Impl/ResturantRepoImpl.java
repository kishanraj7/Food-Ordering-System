package Food_Order.Repositories.Impl;

import Food_Order.Models.Resturant;
import Food_Order.Repositories.ResturantRepo;

import java.util.ArrayList;
import java.util.List;

public class ResturantRepoImpl implements ResturantRepo {
    private List<Resturant> ResturantList = new ArrayList<>();
    public void saveResturant(Resturant resturant) {
        ResturantList.add(resturant);
    }
    public Resturant findById(String id) {
        for (Resturant resturant : ResturantList) {
            if (resturant.getId().equals(id)) {
                return resturant;
            }
        }
        return null;
    }
    public void update(Resturant resturant) {
        int index = -1;
        for (int i = 0; i < ResturantList.size(); i++) {
            if (ResturantList.get(i).getId().equals(resturant.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            ResturantList.set(index, resturant);
        }
    }
    //Delete
    public void deleteById(String id) {
        ResturantList.removeIf(resturant -> resturant.getId().equals(id));
    }
    @Override
    public List<Resturant> findByOwnerId(String ownerId) {
        List<Resturant> result = new ArrayList<>();
        for (Resturant resturant : ResturantList) {
            if (resturant.getOwnerId().equals(ownerId)) {
                result.add(resturant);
            }
        }
        return result;
    }

    public List<Resturant> getList() {
        return  ResturantList;
    }
}
