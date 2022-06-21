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

public class DropMyTopic extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request = DefaultHttp.RequestSetChar(request);
        response = DefaultHttp.ResponseSetChar(response);

        int id = Integer.parseInt(request.getParameter("id"));

        TopicData topic = new TopicData();
        topic.setId(id);
        topic = DataSelect.select(topic);

        topic.setStudent(-1);

        if (DataUpdate.update(topic)) {
            response.sendRedirect(request.getContextPath() + "/IsTopic");
        } else {
            response.getWriter().write("<script language='javascript'>" +
                    "alert('退选失败！');" +
                    "window.location.href='" + request.getContextPath() + "/IsTopic';</script>')");
        }
    }


}
