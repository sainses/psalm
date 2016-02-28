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

import com.sainses.psalm.ent.SysRole;
import com.sainses.psalm.ent.SysUser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * Manage authorizations
 * 
 * @author vuppala
 */
@Stateless
public class AuthEJB {


    private static final Logger logger = Logger.getLogger(AuthEJB.class.getName());
    @PersistenceContext(unitName = "psalm-data")
    private EntityManager em;
    
    /**
     * Find auth roles
     * 
     * @author vuppala 
     * @return all roles
     */
    public List<SysRole> findRoles() {
        List<SysRole> roles;
        TypedQuery<SysRole> query = em.createNamedQuery("SysRole.findAll", SysRole.class);
        roles = query.getResultList();
        logger.log(Level.FINE, "roles found: {0}", roles.size());
        return roles;
    }
    
   
    
    /**
     * Save the given role
     * 
     * @param role 
     */
    public void saveSysRole(SysRole role) {
        if (role.getId() == null) {
            em.persist(role);
        } else {
            em.merge(role);
        }
        logger.log(Level.FINE, "AuthEJB#saveAuthRole: role saved - {0}", role.getName());
    }
    
    /**
     * Delete the given role
     * 
     * @param role 
     */
    public void deleteSysRole(SysRole role) {
        SysRole sysRole = em.find(SysRole.class, role.getId());
        em.remove(sysRole);
    }
    
    
    /**
     * find a role given its id
     * 
     * @param id
     * @return the role
     */
    public SysRole findSysRole(int id) {
        return em.find(SysRole.class, id);
    }
    
    
    // ------------------- Users -------------------
    /**
     * find all users in the system
     * 
     * @return list of users
     */
    public List<SysUser> findUsers() {
        List<SysUser> users;
        TypedQuery<SysUser> query = em.createQuery("SELECT u FROM Sysuser u ORDER BY u.lastName, u.firstName", SysUser.class);
        users = query.getResultList();
        logger.log(Level.FINE, "AuthEJB#findUsers:  found users {0}", users.size());
        return users;
    }

    /**
     * find all users who are current employees
     * 
     * @return list of users
     */
    public List<SysUser> findCurrentUsers() {
        List<SysUser> users;
        TypedQuery<SysUser> query = em.createQuery("SELECT u FROM Sysuser u WHERE u.currentEmployee = TRUE ORDER BY u.lastName, u.firstName", SysUser.class);
        users = query.getResultList();
        logger.log(Level.FINE, "AuthEJB#findCurrentUsers:  found users {0}", users.size());
        return users;
    }
    
    /** 
     * find a user given its id
     * 
     * @param id
     * @return the user 
     */
    public SysUser findUser(int id) {
        return em.find(SysUser.class, id);
    }

    /**
     * Finds user given its login id.
     * 
     *
     * @param loginId  Id of the desired user
     * @return User for the given login id
     */
    public SysUser findUser(String loginId) {
        TypedQuery<SysUser> query = em.createNamedQuery("SysUser.findByLoginId", SysUser.class).setParameter("loginId", loginId);
        List<SysUser> emps = query.getResultList();

        if (emps == null || emps.isEmpty()) {
            logger.log(Level.WARNING, "UserEJB: No user found with id {0}", loginId);
            return null;
        }

        if (emps.size() > 1) {
            logger.log(Level.WARNING, "UserEJB: there are more than 1 employee with the same login id {0}", loginId);
        }
        return emps.get(0);
    }
    
    /**
     * save the given user
     * 
     * @param user 
     */
    public void saveUser(SysUser user) {
        if (user == null) {
            return;
        }
        
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        logger.log(Level.FINE, "HourLogEJB#saveUser: User saved - {0}", user.getId());
    }

    /**
     * delete the given user
     * 
     * @param user 
     */
    public void deleteUser(SysUser user) {
        SysUser muser = em.find(SysUser.class, user.getId());
        em.remove(muser);
    }
     
}
