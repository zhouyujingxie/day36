
package com.qf.servlet;  
  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebInitParam;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
  
/**  
 * name:servlet的名称，可以省路，如果写个能重复  
 * urlPatterns:servlet访问路径value:servlet访问路径，和urlpattern二选一  
 * Loadonstartup:加载时机默认-1,  
 * initParams:servlet的参数  
 */  
@WebServlet(name = "MyServlet3",urlPatterns = "/myservlet3",loadOnStartup = 0,initParams = {@WebInitParam(name = "username",value = "李四"),@WebInitParam(name = "age",value = "30")})  
public class MyServlet3 extends HttpServlet {  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
        doPost(req,resp);  
    }  
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
        System.out.println("MyServlet3开始执行"+this.hashCode());  
        ServletConfig servletConfig = this.getServletConfig();  
        String username = servletConfig.getInitParameter("username");  
        String age = servletConfig.getInitParameter("age");  
        System.out.println(username+"..."+age);  
    }  
}
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE4NTc1OTE2MTVdfQ==
-->