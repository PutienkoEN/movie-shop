package com.servlet;

import com.action.Action;
import com.action.ActionFactory;
import com.action.ActionResult;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = "/do/*")
public class ControllerServlet extends HttpServlet {
    private ActionFactory actionFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionName = request.getMethod() + request.getPathInfo();
        Action action = actionFactory.getAction(actionName);

        if (action == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found");
            return;
        }

        ActionResult result = action.execute(request, response);
        doForwardOrRedirect(result, request, response);
    }

    private void doForwardOrRedirect(ActionResult result, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (result.isRedirect()) {
            String location = request.getContextPath() + "/do/" + result.getView();
            response.sendRedirect(location);
        } else {
            String path = String.format("/WEB-INF/jsp/" + result.getView() + ".jsp");
            request.getRequestDispatcher(path).forward(request, response);
        }

    }
}
