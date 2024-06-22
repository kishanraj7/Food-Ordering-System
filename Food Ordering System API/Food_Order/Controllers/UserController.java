package Food_Order.Controllers;

import Food_Order.Models.User;
import Food_Order.Service.Impl.UserServiceImpl;

public class UserController {
    UserServiceImpl userService = new UserServiceImpl();
    //For Using in UI You Must First Create user Class Object
    public void Register(User user){
        userService.register(user);
    }
    public String Login(String userName, String pass){
        return userService.login(userName,pass);
    }
    public void getProfile(String id){
        userService.getUserprofile(id);
    }
}
