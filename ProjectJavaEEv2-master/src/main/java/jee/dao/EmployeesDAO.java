/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jee.model.Employees;
/**
 *
 * @author Thomas
 */

public class EmployeesDAO implements IEmployeesDAO{
 
    @PersistenceContext
    private EntityManager entityManager;

    public void creerEmployees(final Employees pEmployees) {
        entityManager.persist(pEmployees);
    }
    
    public void supprimerEmployees(final Employees pEmployees){
    	
    	final Employees lEmployees = entityManager.getReference(Employees.class,pEmployees.getId());
    	entityManager.remove(lEmployees);
  
    }
    
    public void modifierEmployees ( final Employees pEmployees) {
       
    	 entityManager.merge(pEmployees);
    }
	
}