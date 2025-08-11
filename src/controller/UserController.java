package controller;

import model.User;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private UserService userService = new UserService();
    Scanner  scanner = new Scanner(System.in);

    public void start(){
        while (true){
            System.out.println("\n1. POST /students  ");
            System.out.println("2. GET /students  ");
            System.out.println("3. GET /students/{id} ");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

             int choice = scanner.nextInt();
             scanner.nextLine();


             switch (choice){
                 case 1:
                     System.out.println("Enter ID: ");
                     int id = scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Enter Name: ");
                     String  name = scanner.nextLine();
                     System.out.println("Enter Age: ");
                     int age = scanner.nextInt();
                     userService.createUser(id,name,age);
                     break;
                 case 2 :
                     List<User> users = userService.listUsers();
                     for (User user : users){
                         System.out.println( user.getName()+ "-" + user.getAge() );
                     }
                     break;

                 case 3 :
                     System.out.println("Enter ID:");
                     int searchId = scanner.nextInt();

                     User user = userService.findUser(searchId);
                     if(user != null){
                         System.out.println("User:" + user.getName());
                     }else{
                         System.out.println("User not found");
                     }
                     break;

                 case 0:
                     return;

                 default:
                     System.out.println("Wrong choice");
             }
        }
    }
}
