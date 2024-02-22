package com.qf.servlet;

import com.qf.entity.Book;
import com.qf.entity.User;
import com.qf.service.BookService;
import com.qf.service.impl.BookServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(urlPatterns = "/booklist")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService=new BookServiceImpl();
        List<Book> bookList=bookService.findAll();
        if (bookList != null) {
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
        }
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer=response.getWriter();
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>图书列表</title>");
            writer.println("</head>");
            writer.println("<body>");
            //输出表格
            writer.println("<h1>图书列表</h1>");
            //获取登录用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }
        writer.println("当前登录用户:"+user.getUsername());
        writer.println("<a href='logout' onclick='return confirm(\"确定要退出吗\")'>退出</a>");
        writer.println("<a href='addbook.html'>添加图书</a>");

        writer.println("<table border='1' align='center'>");
            writer.println("<tr>");
            writer.println("<th>编号</th>");
            writer.println("<th>书名</th>");
            writer.println("<th>作者</th>");
            writer.println("<th>出版日期</th>");
            writer.println("<th>出版社</th>");
            writer.println("<th>isbn</th>");
            writer.println("<th>价格</th>");
            writer.println("<th>图片</th>");
            writer.println("<th>类别</th>");
            writer.println("<th>操作</th>");
            writer.println("</tr>");

        for (Book book : bookList) {
            writer.println("<tr>");
            writer.println("<td>"+book.getTitle()+"</td>");
            writer.println("<td>"+book.getAuthor()+"</td>");
            writer.println("<td>"+book.getAuthor()+"</td>");
            writer.println("<td>"+book.getPublicDate()+"</td>");
            writer.println("<td>"+book.getPublisher()+"</td>");
            writer.println("<td>"+book.getIsbn()+"</td>");
            writer.println("<td>"+book.getPrice()+"</td>");
            writer.println("<td>"+book.getPicture()+"</td>");
            writer.println("<td>"+book.getCid()+"</td>");
            writer.println("<td><a href='deleteservlet?id="+book.getId()+"' onclick='return confirm(\"确定要删除吗？\")'>删除</a></td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
