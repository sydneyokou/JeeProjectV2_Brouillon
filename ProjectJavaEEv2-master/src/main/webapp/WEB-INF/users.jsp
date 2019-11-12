<%-- 
    Document   : users
    Created on : 19 déc. 2018, 09:44:30
    Author     : axelc
--%>

<%@page import="jee.model.Employees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
      <title>Employees List Page</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container">
            <h2>List of Employees</h2>
            <form action="Controller" method="POST">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Sel</th>
                            <th>NAME</th>
                            <th>FIRSTNAME</th>
                            <th>HOMEPHONE</th>
                            <th>MOBILE<br> PHONE</th>
                            <th>WORK<br> PHONE</th>
                            <th>ADDRESS</th>
                            <th>POSTAL<br>CODE</th>
                            <th>CITY</th>
                            <th>EMAIL</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ employeesList }" var="employee" varStatus="status">
                            <tr>     
                                <td><input type='radio' value='${employee.getId()}' class='selected' name='selected' checked="checked"></td>
                                <td><c:out value="${employee.getName()}"/></td>
                                <td><c:out value="${employee.getFirstname()}"/></td>
                                <td><c:out value="${employee.getTelhome()}"/></td>
                                <td><c:out value="${employee.getTelmob()}"/></td>
                                <td><c:out value="${employee.getTelpro()}"/></td>
                                <td><c:out value="${employee.getAdress()}"/></td>
                                <td><c:out value="${employee.getPostalcode()}"/></td>
                                <td><c:out value="${employee.getCity()}"/></td>
                                <td><c:out value="${employee.getEmail()}"/></td>
                            </tr>
                        </c:forEach>          
                    </tbody>
                </table>        
                <input type="submit" class='btn btn-primary' name="action" value="Delete">
                <input type="submit" class='btn btn-primary' name="action" value="Details">
                <input type="submit" class='btn btn-primary' name="action" value="Add">
            </form>
        </div>
    </body>
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    
</html>
