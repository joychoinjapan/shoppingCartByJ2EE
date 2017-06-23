package dao;/**
 * Created by baobaochu on 2017/6/20.
 */

import bean.Product;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品DAO，仅提供查询方法
 *
 * @auther baobaochu
 * @create 2017/6/20
 */
public class ProductDAO {
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

    public List<Product> ListProduct() {
        List<Product> products = new ArrayList<Product>();
        String sql="select * from product order by id desc";
        try(Connection c=getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product product=new Product();
                int id=rs.getInt(1);
                String name=rs.getString("name");
                float price=rs.getFloat("price");

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int id){
        Product result=null;
        String sql="SELECT * from product where id= ?";
        try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                result=new Product();
                result.setId(id);
                String name=rs.getString("name");
                Float price=rs.getFloat("price");
                result.setPrice(price);
                result.setName(name);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }




}
