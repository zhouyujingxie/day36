package com.qf.servlet;

import com.qf.entity.Book;
import com.qf.service.BookService;
import com.qf.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/addbookservlet")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.接收数据
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publicDate = request.getParameter("publicDate");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        String price = request.getParameter("price");
        String cid = request.getParameter("cid");
         //2.
        if (title == null||title.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }
        if (author == null||author.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }
        if (publicDate == null||publicDate.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }
        if (publisher == null||publisher.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }
        if (isbn == null||isbn.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }
        if (price == null||price.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }
        if (cid == null||cid.trim().equals("")) {
            response.sendRedirect("addbook.html");
            return;
        }

        //3.创建业务对象
        BookService bookService=new BookServiceImpl();
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Book book=new Book(0,title,author,sdf.parse(publicDate),publisher,isbn,new BigDecimal(price),null,Integer.parseInt(cid));
            bookService.add(book);
            response.sendRedirect("booklist");
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("addbook.html");
        }

    }
}
