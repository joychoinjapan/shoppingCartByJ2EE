package bean;/**
 * Created by baobaochu on 2017/6/23.
 */

/**
 * 订单bean类
 *
 * @auther baobaochu
 * @create 2017/6/23
 */
public class Order {
    int id;
    User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
