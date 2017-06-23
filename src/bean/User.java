package bean;/**
 * Created by baobaochu on 2017/6/21.
 */

/**
 * user bean 包括id name password
 *
 * @auther baobaochu
 * @create 2017/6/21
 */
public class User {
    private int id;
    private String name;
    private String password;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
