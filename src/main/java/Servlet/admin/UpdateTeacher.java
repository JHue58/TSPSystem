package Servlet.admin;

import Servlet.useDataBase.DataUpdate;
import Servlet.util.Data.TeacherData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UpdateTeacher extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        TeacherData teacher = new TeacherData();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Boolean sex = Objects.equals(request.getParameter("sex"), "1");
        String idcard = request.getParameter("idcard");
        String major = request.getParameter("major");
        String birthday = request.getParameter("birthday");
        String edu = request.getParameter("edu");
        String password = request.getParameter("password");

        teacher.setId(id);
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setIdcard(idcard);
        teacher.setMajor(major);
        teacher.setBirthday(birthday);
        teacher.setEdu(edu);
        teacher.setPassword(password);

        if (DataUpdate.update(teacher)) {
            response.sendRedirect(request.getContextPath() + "/TeacherListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('修改失败！');" +
                    "window.location.href='" + request.getContextPath() + "/TeacherListSelect';</script>')");
        }


    }


}
