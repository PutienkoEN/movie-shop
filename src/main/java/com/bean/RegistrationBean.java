package com.bean;

import com.domain.dao.UserDaoImpl;
import com.domain.model.User;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Hashtable;

public class RegistrationBean {
    private String login;
    private String password1;
    private String password2;
    private String email;
    private String country;
    private Hashtable errors;

    public boolean validate() {
        UserDaoImpl userDao = new UserDaoImpl();
        boolean readyToGo = true;

        if (login.equals("")) {
            errors.put("login", "Please, enter your login!");
            login = "";
            readyToGo = false;
        }
        if (!login.equals("")) {
            userDao.openCurrentSession();
            User user = userDao.findByLogin(login);
            userDao.closeCurrentSession();
            if (user != null) {
                errors.put("login", "User with this login already exist!");
            }
        }
        if (password1.equals("")) {
            errors.put("password1", "Please, enter your password!");
            password1 = "";
            readyToGo = false;
        }
        if (!password1.equals("") && password2.equals("") || !password1.equals(password2)) {
            errors.put("password2", "Please, confirm your password!");
            password2 = "";
            readyToGo = false;
        }
        if (email.equals("")) {
            errors.put("email", "Please, enter your e-mail!");
            email = "";
            readyToGo = false;
        }
        if (!email.equals("")) {
            userDao.openCurrentSession();
            User user = userDao.findByEmail(email);
            userDao.closeCurrentSession();
            if (user != null) {
                errors.put("email", "User with this e-mail already exist!");
            }
        }
        if (country.equals("")) {
            errors.put("country", "Please, enter your country!");
            country = "";
            readyToGo = false;
        }
        return readyToGo;
    }

    public String getErrorMsg(String type) {
        String error = (String) errors.get(type.trim());
        return (error == null) ? "" : error;
    }

    public RegistrationBean() {
        login = "";
        password1 = "";
        password2 = "";
        email = "";
        country = "";
        errors = new Hashtable();
    }

    public RegistrationBean(String login, String password1, String password2, String email, String country) {
        this.login = login;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
        this.country = country;
        errors = new Hashtable();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Hashtable getErrors() {
        return errors;
    }

    public void setErrors(Hashtable errors) {
        this.errors = errors;
    }
}
