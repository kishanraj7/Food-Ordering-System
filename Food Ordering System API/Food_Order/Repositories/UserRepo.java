package Food_Order.Repositories;

import Food_Order.Models.User;

import java.util.List;

public interface UserRepo {
    void saveUser(User user);

    User findByUserName(String userName);
    User findByEmail(String Email);
    List<User> getUserList();
    User findByUserId(String Id);


}
