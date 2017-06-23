package dao;/**
 * Created by baobaochu on 2017/6/23.
 */

import bean.Order;
import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 包含生成一个订单dao的方法
 *
 * @auther baobaochu
 * @create 2017/6/23
 */
public class OrderDAO {
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

    public void insert(Order o){
        String sql="insert into order_ values(null,?)";
        try(Connection c=getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,o.getUser().getId());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                int id=rs.getInt(1);
                o.setId(id);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
