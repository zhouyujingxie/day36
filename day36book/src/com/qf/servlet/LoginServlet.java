package com.qf.servlet;

import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/loginservlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String vcode = request.getParameter("vcode");
        if (username==null||username.trim().equals("")){
            response.sendRedirect("login.html");
            return;
        }

        if (pwd==null||pwd.trim().equals("")){
            response.sendRedirect("login.html");
            return;
        }
        if (vcode == null||vcode.trim().equals("")) {
            response.sendRedirect("login.html");
            return;
        }
        //判断验证码是否正确
        String code = (String) request.getSession().getAttribute("code");
        if (!vcode.equalsIgnoreCase(code)){
            System.out.println("验证码错误");
            response.sendRedirect("login.html");
            return;
        }
        //创建业务对象
        UserService userService=new UserServiceImpl();
        try {
            User user=userService.login(username,pwd);
           /* response.sendRedirect("index.jap");*/
            //把user放入session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("booklist");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("login.html");
        }
    }
}
