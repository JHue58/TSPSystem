package Servlet.admin;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.StudentData;
import Servlet.util.Data.TopicData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IsTopic extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentData student = (StudentData) request.getSession().getAttribute("student");

        TopicData topic = DataSelect.haveTopic(student);

        if (topic == null) {
            response.sendRedirect(request.getContextPath() + "/TopicListDisplay");
        } else {
            request.setAttribute("topic", topic);
            request.getRequestDispatcher("/choice/MyTopic.jsp").forward(request, response);
        }
    }


}
