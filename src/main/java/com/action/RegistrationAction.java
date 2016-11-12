package com.action;

import com.bean.RegistrationBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationAction implements Action {
    private ActionResult index = new ActionResult("home", true);
    private ActionResult registrAgain = new ActionResult("registration");

    public ActionResult execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        RegistrationBean registrationBean = new RegistrationBean(login, password1, password2, email, country);
        if (registrationBean.validate()) {
            return index;
        } else {
            request.setAttribute("registrationForm", registrationBean);
            return registrAgain;
        }
    }
}
