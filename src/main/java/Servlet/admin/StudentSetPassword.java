package Servlet.admin;

import Servlet.useDataBase.DataUpdate;
import Servlet.util.Data.StudentData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentSetPassword extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        String password = request.getParameter("password");
        String Newpassword = request.getParameter("Newpassword");
        String AgainNewpassword = request.getParameter("AgainNewpassword");

        StudentData student = (StudentData) request.getSession().getAttribute("student");

        if (!student.getPassword().equals(password)) {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('密码错误！');" +
                    "window.location.href='" + request.getContextPath() + "/StudentHello.jsp';</script>')");
        } else if (Newpassword.equals(AgainNewpassword)) {
            student.setPassword(Newpassword);
            if (DataUpdate.update(student)) {
                response.getWriter().write("<script language='javascript'>" +
                        "alert('修改成功！请重新登录');" +
                        "window.location.href='" + request.getContextPath() + "/Login.html';</script>')");
            } else {
                response.getWriter().write("<script language='javascript'>" +
                        "alert(修改失败！');" +
                        "window.location.href='" + request.getContextPath() + "/StudentHello.jsp';</script>')");
            }
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('两次密码不一致！');" +
                    "window.location.href='" + request.getContextPath() + "/StudentHello.jsp';</script>')");
        }
    }


}
