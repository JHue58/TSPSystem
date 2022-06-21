package Servlet.Select;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.TeacherData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherSelect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TeacherData teacher = new TeacherData();
        teacher.setId(id);

        teacher = DataSelect.select(teacher);

        request.setAttribute("teacher", teacher);
        request.getRequestDispatcher("admin/UpdateTeacher.jsp").forward(request, response);

    }

}
