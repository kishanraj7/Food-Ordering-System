package Food_Order.Service;

import Food_Order.Models.User;

public interface UserService {
    void register(User user);
    void login(String userName, String password);
    void getUserprofile(String userId);
}
