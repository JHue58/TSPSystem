package Servlet.Select;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.TopicData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TopicSelect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TopicData topic = new TopicData();
        topic.setId(id);

        topic = DataSelect.select(topic);

        request.setAttribute("topic", topic);
        request.getRequestDispatcher("admin/UpdateTopic.jsp").forward(request, response);

    }
}
