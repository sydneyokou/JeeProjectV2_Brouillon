<%-- 
    Document   : login
    Created on : 19 déc. 2018, 08:37:44
    Author     : axelc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container" style="width:20em;">
            <h1> Login</h1>
            <form method='POST' action='Controller'>
                <p>${connection}</p>
                Login <input class="form-control" type="text" name="loginField"></input><br><br>
                Password: <input class="form-control" type="password" name="pwdField"></input><br><br>
                <button class="btn" type="submit">Send</button>
            </form>
        </div>
    </body>
</html>
