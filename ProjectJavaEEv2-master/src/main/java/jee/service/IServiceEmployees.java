/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.service;

/**
 *
 * @author Thomas
 */
public interface IServiceEmployees {
    
    void creerEmployees(final Integer eId,final String eName,final String eFirstName,final String eTelhome ,final String eTelMob,final String eTelpro,final String eAdress,final String ePostalCode, final String eCity,final String eEmail);

    void supprimerEmployees(final Integer id);
	
    void modifierEmployees(final Integer eId,final String eName,final String eFirstName,final String eTelhome ,final String eTelMob,final String eTelpro,final String eAdress,final String ePostalCode, final String eCity,final String eEmail);
	
}
