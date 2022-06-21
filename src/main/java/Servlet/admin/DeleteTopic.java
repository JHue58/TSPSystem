package Servlet.admin;

import Servlet.useDataBase.DataDelete;
import Servlet.util.Data.TopicData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTopic extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        TopicData topic = new TopicData();
        topic.setId(id);
        if (DataDelete.delete(topic)) {
            response.sendRedirect(request.getContextPath() + "/TopicListSelect");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('删除失败！');" +
                    "window.location.href='" + request.getContextPath() + "/TopicListSelect';</script>')");
        }
    }
}
