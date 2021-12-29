package com.lsb.web.room;

import com.lsb.pojo.Room;
import com.lsb.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private RoomService service = new RoomService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理post请求乱码问题
        request.setCharacterEncoding("utf-8");
        // 1.接收表单提交的数据，封装为一个Brand对象
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String borrowDate = request.getParameter("borrowDate");
        System.out.println(borrowDate);
        int userid = Integer.parseInt(request.getParameter("userid"));
        System.out.println(userid);
        // 2.调用service，完成添加
        service.updateById(id,userid);
        // 3.转发到查询所有servlet
        request.getRequestDispatcher("/selectByDateServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
