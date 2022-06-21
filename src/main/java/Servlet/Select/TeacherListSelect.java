package Servlet.Select;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.TeacherList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherListSelect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeacherList teachers = new TeacherList();
        teachers = DataSelect.select(teachers);
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("admin/Teacher.jsp").forward(request, response);
    }


}
