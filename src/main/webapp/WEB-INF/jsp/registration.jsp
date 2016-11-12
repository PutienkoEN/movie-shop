<%--@elvariable id="registrationForm" type="com.bean.RegistrationBean"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<h3>Registration</h3>
<form action="registration" method="post">
    <div>
        Login:
        <input type="text" name="login" value="${registrationForm.login}">
        <br>
        <span class="registration-error-message">${registrationForm.errors["login"]}</span>
    </div>

    <div>
        Password:
        <input type="password" name="password1" value="${registrationForm.password1}">
        <br>
        <span class="registration-error-message">${registrationForm.errors["password1"]}</span>
    </div>

    <div>
        Repeat password:
        <input type="password" name="password2" value="${registrationForm.password2}">
        <br>
        <span class="registration-error-message">${registrationForm.errors["password2"]}</span>
    </div>

    <div>
        E-mail:
        <input type="email" name="email" value="${registrationForm.email}">
        <br>
        <span class="registration-error-message">${registrationForm.errors["email"]}</span>
    </div>

    <div>
        Country:
        <input type="text" name="country" value="${registrationForm.country}">
        <br>
        <span class="registration-error-message">${registrationForm.errors["country"]}</span>
    </div>

    <input type="submit" value="Submit">
</form>
</body>
</html>
