package com.lsb.web.room;

import com.lsb.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private RoomService service = new RoomService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收Id
        String id = request.getParameter("id");
        int userid = Integer.parseInt(request.getParameter("userid"));

        // 2.调用deleteById完成删除

        service.deleteById(Integer.parseInt(id));

        // 3.存入request域中
        request.setAttribute("id", id);
        request.setAttribute("userid",userid);

        // 3.转发到查询所有servlet
        request.getRequestDispatcher("/selectByUserServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
