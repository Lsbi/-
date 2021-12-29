package com.lsb.web.user;

import com.lsb.pojo.User;
import com.lsb.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.封装User对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 3.调用userservice完成查询
        User u = service.selectByUsername(username);
        System.out.println(username);
        if (u == null && username != "" && password != "") {
            //用户名不存在，添加用户
            service.addUser(u);
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else {
            //用户名存在
            if (username == "" || password == ""){
                request.setAttribute("register_msg","请输入用户名或密码");
            }
            else {
                request.setAttribute("register_msg", "用户名已存在");
            }
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
