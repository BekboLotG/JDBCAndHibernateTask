package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args ) throws SQLException {
        // реализуйте алгоритм здесь
//        Util.connection();

        UserService userService= new UserServiceImpl();
//        userService.createUsersTable();
        User user1 = new User("Adam","Ceda",(byte) 20 );
        User user2 = new User("Safiya","Abu",(byte) 21 );
        User user3 = new User("Te","David",(byte) 22 );
        User user4 = new User("K","Da",(byte) 23 );

//        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());List<User> userList=new ArrayList<>();
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());


//        userService.getAllUsers();

//        System.out.println(userService.getAllUsers());

//        userService.dropUsersTable();
//        userService.cleanUsersTable();



    }
}
