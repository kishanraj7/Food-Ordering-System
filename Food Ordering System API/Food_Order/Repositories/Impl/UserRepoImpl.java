package Food_Order.Repositories.Impl;

import Food_Order.Models.User;
import Food_Order.Repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    private List<User> userList =new ArrayList<>();

    @Override
    public void saveUser(User user) {
        userList.add(user);
    }
    public List<User> getUserList() {
        return userList;
    }
    @Override
    public User findByUserName(String userName) {
        for(User user:userList)
        {
            if(user.getUsername().equals(userName))
            {
                return user;
            }
        }
        return null;
    }
    @Override
    public User findByEmail(String Email) {
        for(User user:userList)
        {
            if(user.getEmail().equals(Email))
            {
                return user;
            }
        }
        return null;
    }
    public User findByUserId(String Id){
        for(User user:userList)
        {
            if(user.getId().equals(Id))
            {
                return user;
            }
        }
        return null;
    }
}
