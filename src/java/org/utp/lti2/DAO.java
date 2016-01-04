/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utp.lti2;

/**
 *
 * @author Sourav Kumar Paul
 */

import com.googlecode.objectify.ObjectifyService;

public class DAO extends com.googlecode.objectify.util.DAOBase {
	static { 
		//ObjectifyService.register(Assignment.class);
		ObjectifyService.register(BLTIConsumer.class);
        	}
	

}