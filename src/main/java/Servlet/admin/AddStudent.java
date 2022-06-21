package Servlet.admin;

import Servlet.useDataBase.DataInsert;
import Servlet.util.Data.StudentData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AddStudent extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        StudentData student = new StudentData();

        String name = request.getParameter("name");
        Boolean sex = Objects.equals(request.getParameter("sex"), "1");
        String idcard = request.getParameter("idcard");
        String birthday = request.getParameter("birthday");
        String password = request.getParameter("password");

        student.setName(name);
        student.setSex(sex);
        student.setIdcard(idcard);
        student.setBirthday(birthday);
        student.setPassword(password);

        if (DataInsert.insert(student)) {
            response.sendRedirect(request.getContextPath() + "/StudentListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('添加失败！');" +
                    "window.location.href='" + request.getContextPath() + "/StudentListSelect';</script>')");
        }


    }
}
