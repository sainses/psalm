/*
 * This software is Copyright by the Board of Trustees of Michigan
 *  State University (c) Copyright 2013, 2014.
 *  
 *  You may use this software under the terms of the GNU public license
 *  (GPL). The terms of this license are described at:
 *    http://www.gnu.org/licenses/gpl.txt
 *  
 *  Contact Information:
 *       Facility for Rare Isotope Beam
 *       Michigan State University
 *       East Lansing, MI 48824-1321
 *        http://frib.msu.edu
 */
package com.sainses.psalm.auth;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * An implementation for the AuthManager interface using local entities 
 * 
 * 
 * @author vuppala
 */
@Stateless
public class AuthManager {

    @Inject
    private UserSession userSession;

    @PersistenceContext(unitName = "psalm-data")
    private EntityManager em;
    private static final Logger logger = Logger.getLogger(AuthManager.class.getName());

    public boolean isValidUser() {     
        return (userSession.getUser() != null);
    }

}
