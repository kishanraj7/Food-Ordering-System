package Food_Order.Repositories.Impl;
import Food_Order.Models.FoodItem;
import Food_Order.Models.Order;
import Food_Order.Repositories.OrderRepo;

import java.util.ArrayList;
import java.util.List;

public class OrderRepoImpl implements OrderRepo {
    ResturantRepoImpl repo = new ResturantRepoImpl();
    UserRepoImpl userRepo = new UserRepoImpl();
    private List<Order> orderList =new ArrayList<>();

    @Override
    public void findByResturantId(String resturantId) {
        repo.findById(resturantId);
    }

    @Override
    public void findByCustomerId(String customerId) {
        userRepo.findByUserId(customerId);
    }
    public List<Order> getList() {
        return  orderList;
    }
    public void saveOrder(Order o) {
        orderList.add(o);
    }
    public void updateOrder(String orderId, String status) {
        for (Order order : orderList) {
            if (order.getId().equals(orderId)) {
                order.setStatus(status);
                System.out.println("Order status updated successfully.");
                return;
            }
        }
        System.out.println("Order not found. Unable to update status.");
    }


}

