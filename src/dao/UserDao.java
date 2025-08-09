package dao;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUserById(int Id){
        for(User user : users){
            if(user.getId()== Id){
                return  user;
            }
        }
        return  null;
    }

    public boolean existsById(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
