package Servlet.admin;

import Servlet.useDataBase.DataDelete;
import Servlet.util.Data.StudentData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudent extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StudentData student = new StudentData();
        student.setId(id);
        if (DataDelete.delete(student)) {
            response.sendRedirect(request.getContextPath() + "/StudentListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('删除失败！');" +
                    "window.location.href='" + request.getContextPath() + "/StudentListSelect';</script>')");
        }
    }
}
