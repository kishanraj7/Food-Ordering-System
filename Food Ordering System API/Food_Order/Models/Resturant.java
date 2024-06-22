package Food_Order.Models;

import java.util.*;

public class Resturant {
    private String id;
    private String ownerId;
    private String name;
    private String adress;
    private String phone;
    private String cusine;
    private List foodItems = new ArrayList();

    // Constructor
    public Resturant(String Resid, String ownerId, String name, String adress, String phone,String cusine) {
        this.id = Resid;
        this.ownerId = ownerId;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.cusine=cusine;
    }
    // Getter And Setter

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List foodItems) {
        this.foodItems = foodItems;
    }
}
