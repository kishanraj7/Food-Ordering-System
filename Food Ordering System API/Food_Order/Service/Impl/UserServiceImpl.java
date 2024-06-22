package Food_Order.Service.Impl;

import Food_Order.Models.User;
import Food_Order.Repositories.Impl.UserRepoImpl;
import Food_Order.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepoImpl userRepo = new UserRepoImpl();

    @Override
    public void register(User user) {
        if(userRepo.findByUserName(user.getUsername()) == null && userRepo.findByEmail(user.getEmail()) == null){
            userRepo.saveUser(user);
            System.out.println("User Registered Successfully");
        }
        else {
            System.out.println("This Email Or User NameIs Already Registered");
        }
    }

    @Override
    public String login(String userName, String password) {
        User user=userRepo.findByUserName(userName);
        if(user != null ){
            if(user.getPassword().equals(password)) {
                if(user.getRole().equals("OWNER")||user.getRole().equals("Owner")||user.getRole().equals("owner")) {
                    return "Successfully Login As OWNER";
                }
                else {
                    return "Successfully Login";
                }
            }
            else{
                return  "Invalid Password Entered";
            }
        }
        else{
            return "Invalid User Name";
        }
    }

    @Override
    public void getUserprofile(String userId) {
        List<User> userList=userRepo.getUserList();
        for(User user:userList){
            if(user.getId().equals(userId)){
                System.out.println("User ID ==> "+user.getId());
                System.out.println("User Name ==> "+user.getUsername());
                System.out.println("User Email Address ==> "+user.getEmail());
                System.out.println("User Role ==> "+user.getRole());
            }
        }
    }
}
