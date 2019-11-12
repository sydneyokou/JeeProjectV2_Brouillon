/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.service;

import jee.dao.IEmployeesDAO;
import jee.model.Employees;

/**
 *
 * @author Thomas
 */
public class ServiceEmployees implements IServiceEmployees {
    
private IEmployeesDAO dao;

public 	void creerEmployees (final Integer eId,final String eName,final String eFirstName,final String eTelhome ,final String eTelMob,final String eTelpro,final String eAdress,final String ePostalCode, final String eCity,final String eEmail)
{
        final Employees lEmployees = new Employees();
        lEmployees.setId(eId);
        lEmployees.setName(eName);
        lEmployees.setFirstname(eFirstName);
        lEmployees.setTelhome(eTelhome);
        lEmployees.setTelpro(eTelpro);
        lEmployees.setAdress(eAdress);
        lEmployees.setPostalcode(ePostalCode);
        lEmployees.setCity(eCity);
        lEmployees.setEmail(eEmail);
        
        dao.creerEmployees(lEmployees);
    }


    public void supprimerEmployees(final Integer pIdEmployees) {
        final Employees lEmployees = new Employees();
        lEmployees.setId(pIdEmployees);

        dao.supprimerEmployees(lEmployees);
    }

   
    public void modifierEmployees(final Integer eId,final String eName,final String eFirstName,final String eTelhome ,final String eTelMob,final String eTelpro,final String eAdress,final String ePostalCode, final String eCity,final String eEmail) {
        
        final Employees lEmployees = new Employees();
        lEmployees.setId(eId);
        lEmployees.setName(eName);
        lEmployees.setFirstname(eFirstName);
        lEmployees.setTelhome(eTelhome);
        lEmployees.setTelpro(eTelpro);
        lEmployees.setAdress(eAdress);
        lEmployees.setPostalcode(ePostalCode);
        lEmployees.setCity(eCity);
        lEmployees.setEmail(eEmail);
	        
        dao.modifierEmployees(lEmployees);
        
    }
}
