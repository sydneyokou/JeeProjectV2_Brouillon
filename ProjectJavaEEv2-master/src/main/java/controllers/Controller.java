/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.model.DataAccess;
import jee.model.Employees;
import jee.model.Credentials;
import utils.Constants;

/**
 *
 * @author axelc
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    DataAccess db;
    ArrayList<Credentials> usersList;
    ArrayList<Employees> employeesList;
    Employees employee;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (request.getParameter("logout") != null) {  
            session.invalidate();
        }
        
        request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);
    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action!=null && !action.isEmpty()){
            String id = request.getParameter("selected");
            switch (action) {
                case "Delete":                    
                    delete(request, response, id);
                    break;
                case "Details":
                    getDetails(request, response, id);
                    break;
                case "Add":
                    displayDetailsEmpty(request, response);
                    break;
                case "Update":                  
                    String idEmployee = request.getParameter("idEmployee");
                    
                    if(Integer.parseInt(idEmployee) == -1)
                        addUser(request, response);
                    else
                        updateUser(request, response, Integer.parseInt(idEmployee));
                    break;
                case "Cancel":
                    backToMainPage(request, response);
                    break;
                default: 
                    break;
            }           
        }
        else{
            login(request, response);
        }
        
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    /**
     * The login function
     * @param request
     * @param response 
     * @throws javax.servlet.ServletException 
     * @throws java.io.IOException 
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // User input
        String loginEntered = request.getParameter(Constants.LOGIN_FIELD);
        String pwdEntered = request.getParameter(Constants.PWD_FIELD);
                
        db = new DataAccess();
        usersList = db.getUsers(
                db.getResultSet(
                        db.getStatement(
                                db.getConnection()),
                        Constants.ALL_CREDENTIALS));
        
        //Compare credentials only if the user has entered something
        if (loginEntered != null && pwdEntered != null && !loginEntered.equals("") && !pwdEntered.equals("")) {
            for (Credentials u : usersList) {

                if ((loginEntered.equals(u.getLogin())) && pwdEntered.equals(u.getPwd())) {
                    //Get the current session
                    HttpSession session = request.getSession();
                    session.setAttribute("login", loginEntered);
                    //session.setAttribute("password", pwdEntered);

                    backToMainPage(request, response);
                }
                else{
                    // Send back to the login page with the wrong credentials message
                    request.setAttribute("connection", "Wrong username or password.");
                    request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);
                }
            }
        } else {
            // Send back to the login page with the missing input message
            request.setAttribute("connection", "Please fill both input.");
            request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);
        }
        
        
    }
    
    
    /**
     * Delete an employee based on his id
     * @param request
     * @param response
     * @param id
     * @throws ServletException
     * @throws IOException 
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        db = new DataAccess();      
        db.executeSet(
                db.getStatement(
                        db.getConnection()), 
                Constants.DELETE_USER + id);
        
        backToMainPage(request, response);
    }
    
    
    /**
     * Get details on one employee based on his id
     * @param request
     * @param response
     * @param id
     * @throws ServletException
     * @throws IOException 
     */
    protected void getDetails(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        db = new DataAccess();   
        employee = db.getEmployee(
                            db.getResultSet(
                                    db.getStatement(
                                            db.getConnection()), 
                                    Constants.GET_USER + id));
       
        request.setAttribute("employee", employee);
        request.getRequestDispatcher(Constants.DETAILS_PAGE).forward(request, response);
        
    }
    
    
    /**
     * When the user clicks on Cancel he is redirected to the list of employees (main page), or when an operation is done
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void backToMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        employeesList = db.getEmployees(
                            db.getResultSet(
                                    db.getStatement(
                                            db.getConnection()), 
                                    Constants.ALL_EMPLOYEES));

        if(employeesList.isEmpty()){
            // Send to the user page to show the users
            request.setAttribute("employeesList", "empty");
            request.getRequestDispatcher(Constants.USERS_EMPTY_PAGE).forward(request, response);
        }
        else{
            // Send to the user page to show the users
            request.setAttribute("employeesList", employeesList);
            request.getRequestDispatcher(Constants.USERS_PAGE).forward(request, response);
        }
        
    }
    
    
    /**
     * Display the details page with empty inputs
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void displayDetailsEmpty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        employee = new Employees();
        
        request.setAttribute("employee", employee);
        request.getRequestDispatcher(Constants.DETAILS_PAGE).forward(request, response);
    }
    
    
    /**
     * Create a new employee
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // faire des tests pour valider les données (ex: tel seulement 10 chiffres
        ArrayList dataEmployee = new ArrayList();
        dataEmployee.add(request.getParameter("name"));
        dataEmployee.add(request.getParameter("firstname"));
        dataEmployee.add(request.getParameter("telhome"));
        dataEmployee.add(request.getParameter("telmob"));
        dataEmployee.add(request.getParameter("telpro"));
        dataEmployee.add(request.getParameter("address"));
        dataEmployee.add(request.getParameter("postalcode"));
        dataEmployee.add(request.getParameter("city"));
        dataEmployee.add(request.getParameter("email"));

        String queryWhere = "('" + dataEmployee.get(0) + "'";
        for(int i=1; i<dataEmployee.size(); i++){
            queryWhere += ",'" + dataEmployee.get(i) + "'";
        }
        queryWhere += ")";
        
        db = new DataAccess();      
        db.executeSet(
                db.getStatement(
                        db.getConnection()), 
                Constants.ADD_USER + queryWhere);
        
        backToMainPage(request, response);
        
        /* Possible implementation for the persistence with JPA, but the persistence.xml file prevents the project from running
        Employees employee = new Employees(
                0,
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0),
                (String)dataEmployee.get(0)
        );
        
        EmployeesDAO dao = new EmployeesDAO();
        dao.creerEmployees(employee);*/       
    }
    
    
    /**
     * Update an already existing employee
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void updateUser(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException{
        // faire des tests pour valider les données (ex: tel seulement 10 chiffres
        ArrayList dataEmployee = new ArrayList();
        dataEmployee.add(request.getParameter("name"));
        dataEmployee.add(request.getParameter("firstname"));
        dataEmployee.add(request.getParameter("telhome"));
        dataEmployee.add(request.getParameter("telmob"));
        dataEmployee.add(request.getParameter("telpro"));
        dataEmployee.add(request.getParameter("address"));
        dataEmployee.add(request.getParameter("postalcode"));
        dataEmployee.add(request.getParameter("city"));
        dataEmployee.add(request.getParameter("email"));

        String[] nameCol = new String[]{"firstname","telhome","telmob","telpro","adress","postalcode","city","email"};   
        
        String querySet = " name='" + dataEmployee.get(0) + "'";
        for(int i=1; i<dataEmployee.size(); i++){
            querySet += "," + nameCol[i-1] + "='" + dataEmployee.get(i) + "'";
        }
        
        String queryWhere = "WHERE id=" + id;

        db = new DataAccess();      
        int result = db.executeSet(
                db.getStatement(
                        db.getConnection()),
                Constants.UPDATE_USER + querySet + " " + queryWhere);
        
        backToMainPage(request, response);
    }
}
