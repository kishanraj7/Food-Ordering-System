package Food_Order.Repositories;

import Food_Order.Models.Order;

import java.util.List;

public interface OrderRepo {
    void findByResturantId(String resturantId);
    void findByCustomerId(String customerId);
    List<Order> getList();
    void saveOrder(Order o);

}
