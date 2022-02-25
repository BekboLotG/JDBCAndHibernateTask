package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {

        String sql = "create table if not exists users("+
                "id serial,"+
                "name varchar(255) not null,"+
                "lastName varchar(255) not null," +
                "age int not null,"+
                "primary key(id));";

        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){

            statement.executeUpdate(sql);
            System.out.println(" table  \"users\" is created successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sqlDrop = "drop table if exists users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sqlDrop);
            System.out.println("Table drop");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection =Util.connection()){
            PreparedStatement preparedStatement=connection.prepareStatement("insert into users(name,lastname,age)"+"values(?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.println(name +" saving...");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String sql_remove="delete from users where id=?";

        try(Connection connection=Util.connection();
            Statement statement =connection.createStatement()){
            statement.executeUpdate(sql_remove);
            System.out.println("Remove");

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public List<User> getAllUsers() {
        List<User>userList=new ArrayList<>();
        String sql_users="select * from users";
        try(Connection connection=Util.connection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql_users)){
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                User user= new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
//                System.out.println(userList);
//

                System.out.println("id: "+user.getId());
                System.out.println("name: "+user.getName());
                System.out.println("lastname: "+user.getLastName());
                System.out.println("age: "+user.getAge());
                System.out.println("********************************");
            }
        }catch(SQLException e){
            e.printStackTrace();

        }

        return userList;
    }

    public void cleanUsersTable() {
        String sql_clean="truncate table users";

        try(Connection connection =Util.connection();
            Statement statement=connection.createStatement()){
            statement.executeUpdate(sql_clean);
            System.out.println("Cleaned the table...");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}