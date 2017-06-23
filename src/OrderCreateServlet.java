import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by baobaochu on 2017/6/24.
 */
@WebServlet(name = "OrderCreateServlet")
public class OrderCreateServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User u=(User)request.getSession().getAttribute("user");
        if(u==null){
            response.sendRedirect("login.jsp");
            return;
        }

        Order o=new Order();
        o.setUser(u);

        new OrderDAO().insert(o);

        List<OrderItem> ois=(List<OrderItem>) request.getSession().getAttribute("ois");

        for(OrderItem oi:ois){
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }
        ois.clear();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("订单创建成功");

    }


}
