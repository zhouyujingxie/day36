package com.qf.servlet;

import com.qf.service.BookService;
import com.qf.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteservlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        String id = request.getParameter("id");
        //2.非空检验
        if (id == null ||id.trim().equals("")) {
            response.sendRedirect("booklist");
            return;
        }
        //3.创建业务对象
        BookService bookService=new BookServiceImpl();
        try {
            bookService.delete(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("booklist");
    }
}
