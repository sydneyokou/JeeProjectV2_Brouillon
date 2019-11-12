/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  axelc
 * Created: 19 déc. 2018
 */

DROP TABLE IF EXISTS CREDENTIALS;

CREATE TABLE CREDENTIALS (
        ID int NOT NULL AUTO_INCREMENT,
	LOGIN VARCHAR(25) NOT NULL,
	PWD VARCHAR(25) NOT NULL,
	CONSTRAINT primary_key_credentials PRIMARY KEY (ID)
);

INSERT INTO CREDENTIALS(LOGIN,PWD) VALUES('admin','admin');

