package Servlet.Select;

import Servlet.useDataBase.DataSelect;
import Servlet.util.Data.TopicList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TopicListDisplay extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TopicList topics = new TopicList();
        topics = DataSelect.select(topics);
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("choice/ChoiceTopic.jsp").forward(request, response);
    }
}
