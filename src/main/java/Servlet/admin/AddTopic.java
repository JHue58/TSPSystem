package Servlet.admin;

import Servlet.useDataBase.DataInsert;
import Servlet.util.Data.TopicData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTopic extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        TopicData topic = new TopicData();

        String name = request.getParameter("name");
        String properties = request.getParameter("properties");
        String source = request.getParameter("source");
        String workload = request.getParameter("workload");
        String level = request.getParameter("level");
        String description = request.getParameter("description");
        String mission = request.getParameter("mission");
        int Student = -1;

        topic.setName(name);
        topic.setProperties(properties);
        topic.setSource(source);
        topic.setWorkload(workload);
        topic.setLevel(level);
        topic.setDescription(description);
        topic.setMission(mission);
        topic.setStudent(Student);


        if (DataInsert.insert(topic)) {
            response.sendRedirect(request.getContextPath() + "/TopicListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('添加失败！');" +
                    "window.location.href='" + request.getContextPath() + "/TopicListSelect';</script>')");
        }


    }
}
