package com.qf.servlet;  
  
import javax.servlet.*;  
import java.io.IOException;  
  
public class MyServlet1 implements Servlet {  
    //初始化Servlet,只执行一次  
    @Override  
    public void init(ServletConfig servletConfig) throws ServletException {  
        System.out.println("inut执行了。。。"+this.hashCode());  
    }  
   //获取servlet配置  
    @Override  
    public ServletConfig getServletConfig() {  
        System.out.println("getServletConfig执行了。。。"+this.hashCode());  
        return null;  
    }  
    //服务方法，接收请求和响应，请求一次执行一次  
    @Override  
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {  
        System.out.println("service执行了。。。"+this.hashCode());  
    }  
    //获取基本信息  
    @Override  
    public String getServletInfo() {  
        System.out.println("getServletInfo执行了。。。"+this.hashCode());  
        return null;  
    }  
    //销毁方法 只执行一次  
    @Override  
    public void destroy() {  
        System.out.println("destroy执行了。。。"+this.hashCode());  
    }  
}


> Written with [StackEdit中文版](https://stackedit.cn/).
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTMzMTEzMjkyMV19
-->