package Servlet.admin;

import Servlet.useDataBase.DataUpdate;
import Servlet.util.Data.StudentData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UpdateStudent extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        StudentData student = new StudentData();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Boolean sex = Objects.equals(request.getParameter("sex"), "1");
        String idcard = request.getParameter("idcard");
        String birthday = request.getParameter("birthday");
        String password = request.getParameter("password");

        student.setId(id);
        student.setName(name);
        student.setSex(sex);
        student.setIdcard(idcard);
        student.setBirthday(birthday);
        student.setPassword(password);

        if (DataUpdate.update(student)) {
            response.sendRedirect(request.getContextPath() + "/StudentListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('修改失败！');" +
                    "window.location.href='" + request.getContextPath() + "/StudentListSelect';</script>')");
        }


    }
}
