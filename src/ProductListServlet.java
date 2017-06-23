import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by baobaochu on 2017/6/20.
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products=new ProductDAO().ListProduct();
        request.setAttribute("products",products);
        request.getRequestDispatcher("listProduct.jsp").forward(request,response);
    }


}
