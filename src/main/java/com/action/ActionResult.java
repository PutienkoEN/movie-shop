package com.action;

public class ActionResult {
    private final String view;
    private final boolean redirect;

    public ActionResult(String view) {
        this.view = view;
        this.redirect = false;
    }

    public ActionResult(String view, boolean redirect) {
        this.view = view;
        this.redirect = redirect;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public String getView() {
        return view;
    }
}
