package Servlet.Select;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.StudentData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentDisplay extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StudentData student = new StudentData();
        student.setId(id);

        student = DataSelect.select(student);

        request.setAttribute("student", student);

        request.getRequestDispatcher("choice/StudentDisplay.jsp").forward(request, response);
    }


}
