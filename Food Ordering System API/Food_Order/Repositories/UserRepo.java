package Food_Order.Repositories;

public interface UserRepo {
    void findByUserName(String userName);
    void findByEmail(String Email);


}
