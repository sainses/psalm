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

import com.sainses.psalm.ent.SysUser;
import com.sainses.psalm.util.Utility;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;


/**
 * The session.
 * 
 * @author vuppala
 */
@Named
@SessionScoped
public class UserSession implements Serializable {
    @EJB
    private AuthEJB authEJB;
    
    private static final Logger logger = Logger.getLogger(UserSession.class.getName());

    private String loginId; // user unique login name
    private String token;   // auth token
    private SysUser user;
    private String currentTheme; // current GUI theme

    public UserSession() {
        
    }
    
    public void UserSession() {
    }

    /**
     * Initialize user session.
     *
     * @author vuppala
     *
     */
    @PostConstruct
    public void init() {
        try {
            
            // currentTheme = prefEJB.defaultThemeName();
            logger.log(Level.SEVERE, "UserSession: initialized");           
        } catch (Exception e) {
            logger.log(Level.SEVERE, "UserSession: Can not initialize: {0}", e.getMessage());
        }

    }

    /**
     * Start user session
     *
     * @author vuppala
     * @param loginid User login id
     * @param role User role
     *
     */
    public void start(String loginid)  {
        this.loginId = loginid;
        
        user = authEJB.findUser(loginid);
        
        if (user != null) {
            
            
            
        } else {
            logger.log(Level.WARNING, "User not defined in the Hour Log database: {0}", loginid);
            Utility.showMessage(FacesMessage.SEVERITY_FATAL, "You are not registered as Psalm user", "Please contact Psalm administrator.");
        }
        // facility = facilityEJB.defaultFacility(user);      
        //logbook = facility.getOpsLogbook();
        if (currentTheme == null) {
            // currentTheme = prefEJB.defaultThemeName();
        }
        
        // loggedIn = true;
    }

    
    
    /**
     * end user session
     *
     * @author vuppala
     *
     */
    public void end() {
        loginId = null;
        user = null;
        // loggedIn = false;
        token = null;
    }

    // -- getters/setters 
    
    public String getUserId() {
        return loginId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SysUser getUser() {
        return user;
    }

    public String getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
    }    
}
