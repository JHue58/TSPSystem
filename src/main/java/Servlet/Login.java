package Servlet;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.StudentData;
import Servlet.util.Data.TeacherData;
import Servlet.util.Data.User;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        switch (request.getParameter("status")) {
            case "0": {
                response.getWriter().write("<script language='javascript'>" +
                        "alert('请选择身份！');" +
                        "window.location.href='Login.html';</script>')");
                break;
            }
            case "1": {
                int id = Integer.parseInt(username);

                TeacherData teacher = new TeacherData();
                teacher.setId(id);

                teacher = DataSelect.select(teacher);

                if (password.equals(teacher.getPassword())) {
                    request.getSession().setAttribute("teacher", teacher);
                    response.sendRedirect(request.getContextPath() + "/TeacherHello.jsp");

                } else {
                    response.getWriter().write("<script language='javascript'>" +
                            "alert('您输入的账号或密码错误，请重新输入！');" +
                            "window.location.href='Login.html';</script>')");
                }
                break;
            }
            case "2": {
                int id = Integer.parseInt(username);

                StudentData student = new StudentData();
                student.setId(id);

                student = DataSelect.select(student);

                if (password.equals(student.getPassword())) {
                    request.getSession().setAttribute("student", student);
                    response.sendRedirect(request.getContextPath() + "/StudentHello.jsp");

                } else {
                    response.getWriter().write("<script language='javascript'>" +
                            "alert('您输入的账号或密码错误，请重新输入！');" +
                            "window.location.href='Login.html';</script>')");
                }
                break;
            }
            case "3": {
                User user = new User();
                user.setUsername(username);

                user = DataSelect.select(user);

                if (password.equals(user.getPassword())) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/Hello.jsp");

                } else {
                    response.getWriter().write("<script language='javascript'>" +
                            "alert('您输入的账号或密码错误，请重新输入！');" +
                            "window.location.href='Login.html';</script>')");

                }
            }
        }


    }

}
