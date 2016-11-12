package com.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private Map<String, Action> actions;
    public  ActionFactory() {
        actions = new HashMap<String, Action>();
        actions.put("GET/registration", new RegistrationPage("registration"));
        actions.put("POST/registration", new RegistrationAction());
    }
    public Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
