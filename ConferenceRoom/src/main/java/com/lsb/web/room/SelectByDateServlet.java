package com.lsb.web.room;

import com.lsb.pojo.Room;
import com.lsb.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByDateServlet")
public class SelectByDateServlet extends HttpServlet {
    private RoomService service = new RoomService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.获得borrowdate
        String borrowDate = request.getParameter("borrowDate");
        // 2.调用BrandService完成查询

        List<Room> rooms = service.selectByDate(borrowDate);

        // 3.存入request域中
        request.setAttribute("rooms", rooms);

        // 3.转发到room.jsp
        request.getRequestDispatcher("/room.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
