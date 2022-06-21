package Servlet.admin;

import Servlet.useDataBase.DataSelect;
import Servlet.useDataBase.DataUpdate;
import Servlet.util.Data.TopicData;
import Servlet.util.DefaultHttp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTopic extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        TopicData topic = new TopicData();

        int id = Integer.parseInt(request.getParameter("id"));
        topic.setId(id);

        String name = request.getParameter("name");
        String properties = request.getParameter("properties");
        String source = request.getParameter("source");
        String workload = request.getParameter("workload");
        String level = request.getParameter("level");
        String description = request.getParameter("description");
        String mission = request.getParameter("mission");

        topic = DataSelect.select(topic);

        topic.setName(name);
        topic.setProperties(properties);
        topic.setSource(source);
        topic.setWorkload(workload);
        topic.setLevel(level);
        topic.setDescription(description);
        topic.setMission(mission);

        if (DataUpdate.update(topic)) {
            response.sendRedirect(request.getContextPath() + "/TopicListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('修改失败！');" +
                    "window.location.href='" + request.getContextPath() + "/TopicListSelect';</script>')");
        }


    }
}
