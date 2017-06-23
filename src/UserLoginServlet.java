import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by baobaochu on 2017/6/21.
 */
@WebServlet(name = "UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        User user=new UserDAO().getUser(name,password);
        if(null!=user){
            System.out.println("chenggong");
            request.getSession().setAttribute("user",user);
            response.sendRedirect("listProduct");


        }else{
            System.out.println("error");
            response.sendRedirect("index.jsp");
        }
    }


}
