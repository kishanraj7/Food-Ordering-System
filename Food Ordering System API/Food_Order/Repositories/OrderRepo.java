package Food_Order.Repositories;

public interface OrderRepo {
    void findByResturantId(String resturantId);
    void findByCustomerId(String customerId);

}
