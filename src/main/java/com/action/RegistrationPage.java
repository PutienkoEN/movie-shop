package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPage implements Action {

    ActionResult registrationPage;

    public RegistrationPage(String name) {
        registrationPage = new ActionResult(name);
    }

    public ActionResult execute(HttpServletRequest request, HttpServletResponse response) {
        return registrationPage;
    }
}
