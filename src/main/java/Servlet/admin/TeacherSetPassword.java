package Servlet.admin;

import Servlet.useDataBase.DataUpdate;
import Servlet.util.Data.TeacherData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherSetPassword extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        String password = request.getParameter("password");
        String Newpassword = request.getParameter("Newpassword");
        String AgainNewpassword = request.getParameter("AgainNewpassword");

        TeacherData teacher = (TeacherData) request.getSession().getAttribute("teacher");

        if (!teacher.getPassword().equals(password)) {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('密码错误！');" +
                    "window.location.href=" + request.getContextPath() + "'/TeacherHello.jsp';</script>')");
        } else if (Newpassword.equals(AgainNewpassword)) {
            teacher.setPassword(Newpassword);
            if (DataUpdate.update(teacher)) {
                response.getWriter().write("<script language='javascript'>" +
                        "alert('修改成功！请重新登录');" +
                        "window.location.href='" + request.getContextPath() + "/Login.html';</script>')");
            } else {
                response.getWriter().write("<script language='javascript'>" +
                        "alert(修改失败！');" +
                        "window.location.href=" + request.getContextPath() + "'/TeacherHello.jsp';</script>')");
            }
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('两次密码不一致！');" +
                    "window.location.href='" + request.getContextPath() + "/TeacherHello.jsp';</script>')");
        }
    }
}
