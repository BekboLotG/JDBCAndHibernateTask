package peaksoft.util;

import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
   public static final String url="jdbc:postgresql://localhost:5432/postgres";
   public static final String username="postgres";
   public static final String password="bekbolot";

   public static Connection connection() {
       Connection connection= null;
       try {
           connection = DriverManager.getConnection(url, username, password);
           System.out.println("Connected to the PostgresSQL successfully");
       }catch (SQLException e){
           e.printStackTrace();
       }
       return connection;

   }

//   public static void createUsersTable(){
//       String sql = "create table if not exists users"+
//               "(id serial,"+
//               "name varchar(255) not null,"+
//               "lastName varchar(255) not null," +
//               "age int not null,"+
//               "primary key(id));";
//
//       try (
//           Connection connection = Util.connection();
//           Statement statement = connection.createStatement()){
//           statement.executeUpdate(sql);
//           System.out.println(" table  \"users\" is created successfully");
//       }catch (SQLException e){
//           e.printStackTrace();
//       }
//
//   }

     public void dropUsersTable(){

       }

     }




