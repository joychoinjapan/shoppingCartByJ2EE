package dao;/**
 * Created by baobaochu on 2017/6/21.
 */

import bean.Product;
import bean.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据name和password查询表user,如果有数据就表示账号密码正确
 *
 * @auther baobaochu
 * @create 2017/6/21
 */
public class UserDAO {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "cart";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";


    List<Product> products = new ArrayList<Product>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }


    public User getUser(String name,String password){
        User result=null;
        String sql="select * from user where name = ? and password = ?";
        try(Connection c=getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                result=new User();
                result.setId(rs.getInt(1));
                result.setPassword(password);
                result.setName(name);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {


        System.out.println(new UserDAO().getUser("tom", "123").getId());

    }
}
