/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author axelc
 */
public class Constants {
    //Constants related to the properties file
    public static final String PATH_PROPERTIES_FILE = "utils/db.properties";
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PWD = "dbPwd";

    public static final String LOGIN_FIELD = "loginField";
    public static final String PWD_FIELD = "pwdField";

    public static final String USERS_PAGE = "WEB-INF/users.jsp";
    public static final String USERS_EMPTY_PAGE = "WEB-INF/usersEmpty.jsp";
    public static final String LOGIN_PAGE = "WEB-INF/login.jsp";
    public static final String DETAILS_PAGE = "WEB-INF/details.jsp";

    public static final String DISCONNECT_IMAGE = "WEB-INF/disconnect.png";
    
    public static final String ALL_CREDENTIALS = "SELECT * from CREDENTIALS";
    public static final String ALL_EMPLOYEES = "SELECT * from EMPLOYEES";
    public static final String DELETE_USER = "DELETE from EMPLOYEES WHERE id=";
    public static final String GET_USER = "SELECT * from EMPLOYEES WHERE id=";
    public static final String ADD_USER = "INSERT INTO EMPLOYEES (NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADRESS,POSTALCODE,CITY,EMAIL) values";
    public static final String UPDATE_USER = "UPDATE EMPLOYEES SET";
}
