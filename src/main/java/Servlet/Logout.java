package Servlet;

import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        Enumeration em = request.getSession()
                .getAttributeNames();
        //得到session中所有的属性名
        while (em.hasMoreElements()) {
            request.getSession()
                    .removeAttribute(em.nextElement()
                            .toString());
            //遍历删除session中的值
        }


        response.getWriter().write("<script language='javascript'>" +
                "alert('注销成功');" +
                "window.location.href='" + request.getContextPath() + "/Login.html';</script>')");
    }


}
