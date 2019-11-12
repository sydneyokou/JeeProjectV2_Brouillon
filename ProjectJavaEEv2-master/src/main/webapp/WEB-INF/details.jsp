<%-- 
    Document   : details
    Created on : 10 janv. 2019, 13:37:31
    Author     : axelc
--%>

<%@page import="jee.model.Employees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employees Details Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    </head>
    <body class="container">
        <c:import url="navbar.jsp"/>
        <h1>Employees Details Page</h1><hr>
        <% Employees employee = (Employees)request.getAttribute("employee"); %>
        <h3>Details of employee : ${employee.getFirstname()}</h3>
        <form action="Controller" method="POST">
            <input type="hidden" name="idEmployee" value="${employee.getId()}">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" value='${employee.getName()}'>
                </div>                
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Firstname</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="firstname" value='${employee.getFirstname()}'>
                </div>                
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Home phone</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="telhome" value='${employee.getTelhome()}'>
                </div>                
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Mobile phone</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="telmob" value='${employee.getTelmob()}'>
                </div>                
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Professional phone</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="telpro" value='${employee.getTelpro()}'>
                </div>                
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="address" value='${employee.getAdress()}'>
                </div>                
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Postal Code</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="postalcode" value='${employee.getPostalcode()}'>
                </div>                
            </div>
            <div class="row">
                <div class="col">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">City</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="city" value='${employee.getTelhome()}'>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Email address</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" value='${employee.getEmail()}'>
                        </div>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" name="action" value="Update">Save</button>
            <button type="submit" class="btn" name="action" value="Cancel">Cancel</button>
        </form>
    </body>
</html>
