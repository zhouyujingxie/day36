package com.qf.servlet;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/imageservlet")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1创建ValidateCode对象
        ValidateCode validateCode = new ValidateCode(120,30,4,20);
         //2.session中保存验证码
        String code = validateCode.getCode();
        request.getSession().setAttribute("code",code);
        System.out.println("code"+code);
        //3.把图片返回浏览器
        validateCode.write(response.getOutputStream());

    }
}
