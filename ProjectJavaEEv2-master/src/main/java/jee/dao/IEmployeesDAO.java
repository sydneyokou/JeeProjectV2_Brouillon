/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.dao;

import jee.model.Employees;

/**
 *
 * @author Thomas
 */
public interface IEmployeesDAO {
    
    void creerEmployees(final Employees pEmployees);

    void supprimerEmployees(final Employees pEmployees);
	
    void modifierEmployees(final Employees pEmployees);
    
}
