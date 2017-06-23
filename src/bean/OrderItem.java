package bean;/**
 * Created by baobaochu on 2017/6/22.
 */


/**
 * 订单项目 bean
 *
 * @auther baobaochu
 * @create 2017/6/22
 */
public class OrderItem {
    private  int id;
    private  Product product;
    private  int num;
    private  Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
