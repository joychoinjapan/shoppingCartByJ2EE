import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baobaochu on 2017/6/22.
 */
@WebServlet(name = "OrderItemServlet")
public class OrderItemServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));
        int pid=Integer.parseInt(request.getParameter("pid"));
        Product p=new ProductDAO().getProduct(pid);

        OrderItem oi=new OrderItem();
        oi.setNum(num);
        oi.setProduct(p);

        List<OrderItem> ois=(List<OrderItem>) request.getSession().getAttribute("ois");

        if(ois==null){
            ois=new ArrayList<OrderItem>();
            request.getSession().setAttribute("ois",ois);
        }

        ois.add(oi);
        response.sendRedirect("listOrderItem");

    }


}
