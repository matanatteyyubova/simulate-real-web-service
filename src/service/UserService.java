package service;

import dao.UserDao;
import model.User;
import java.util.List;

public class UserService {
    private UserDao userDao =new UserDao();

    public void createUser(int id, String name, int age){
        if( id<0){
            System.out.println("ID cannot be zero or negative!");
            return;
        }
        if(userDao.existsById(id)){
            System.out.println("This ID already exists!");
            return;
        }

        if(name == null || name.isEmpty()){
            System.out.println("Name cannot be empty!");
            return;
        }
        if(age<=0){
            System.out.println("Age cannot be zero or negative!");
            return;
        }
        userDao.addUser(new User( id, name,age));
    }

    public List<User> listUsers(){
        return userDao.getUsers();
    }
     public User findUser( int id){
        return  userDao.getUserById(id);
     }
}
