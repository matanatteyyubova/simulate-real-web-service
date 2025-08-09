package service;

import dao.UserDao;
import model.User;
import java.util.List;

public class UserService {
    private UserDao userDao =new UserDao();

    public void createUser(int id, String name, int age){
        if( id<0){
            System.out.println("ID sıfır və ya mənfi ola bilməz!");
            return;
        }
        if(userDao.existsById(id)){
            System.out.println("Bu ID artıq mövcuddur!");
            return;
        }

        if(name == null || name.isEmpty()){
            System.out.println("Ad boş ola bilməz!");
            return;
        }
        if(age <0){
            System.out.println("Yaş sıfır və ya mənfi ola bilməz!");
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
