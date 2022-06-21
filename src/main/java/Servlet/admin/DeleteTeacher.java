package Servlet.admin;

import Servlet.useDataBase.DataDelete;
import Servlet.util.Data.TeacherData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTeacher extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        TeacherData teacher = new TeacherData();
        teacher.setId(id);
        if (DataDelete.delete(teacher)) {
            response.sendRedirect(request.getContextPath() + "/TeacherListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('删除失败！');" +
                    "window.location.href='" + request.getContextPath() + "/TeacherListSelect';</script>')");
        }
    }


}
