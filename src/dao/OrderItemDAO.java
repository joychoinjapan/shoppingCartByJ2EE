package dao;/**
 * Created by baobaochu on 2017/6/24.
 */

import bean.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 订单项目DAO，提供插入订单项目的方法
 *
 * @auther baobaochu
 * @create 2017/6/24
 */
public class OrderItemDAO {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "cart";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";

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

    public void insert(OrderItem oi){
        String sql="insert into orderitem values(null,?,?,?)";
        try(Connection c=getConnection(); PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            ps.setInt(3,oi.getOrder().getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
