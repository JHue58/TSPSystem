package Servlet.Select;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.StudentList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentListSelect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentList students = new StudentList();
        students = DataSelect.select(students);
        request.setAttribute("students", students);
        request.getRequestDispatcher("admin/Student.jsp").forward(request, response);
    }
}
