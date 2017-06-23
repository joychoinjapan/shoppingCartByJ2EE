package bean;/**
 * Created by baobaochu on 2017/6/20.
 */

/**
 * 产品类：id name price
 *
 * @auther baobaochu
 * @create 2017/6/20
 */
public class Product {
    private int id;
    private String name;
    private float price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
