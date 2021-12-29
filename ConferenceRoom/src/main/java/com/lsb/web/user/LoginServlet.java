package com.lsb.web.user;

import com.lsb.pojo.User;
import com.lsb.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.调用userservice完成查询
        User user = service.selectUser(username, password);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 3.判断user是否未null
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/personal.jsp").forward(request, response);
        }else {
            request.setAttribute("login_error","用户名或密码错误");

            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
