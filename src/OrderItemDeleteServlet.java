import bean.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baobaochu on 2017/6/23.
 */
@WebServlet(name = "OrderItemDeleteServlet")
public class OrderItemDeleteServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid=Integer.parseInt(request.getParameter("pid"));
        List<OrderItem> ois=(List<OrderItem>)request.getSession().getAttribute("ois");
        List<OrderItem> oid4Delete=new ArrayList<>();
        if(null!=ois){
            for(OrderItem io:ois){
                if(io.getProduct().getId()==pid){
                    oid4Delete.add(io);
                }
            }
        }
        ois.removeAll(oid4Delete);
        response.sendRedirect("listOrderItem");
    }


}
