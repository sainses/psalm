/*
 * This software is Copyright by the Board of Trustees of Michigan
 *  State University (c) Copyright 2013.
 *  State University (c) Copyright 2013.
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
package com.sainses.psalm.converter;

import com.sainses.psalm.ejb.ProjectEJB;
import com.sainses.psalm.ent.Project;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/**
 * Project converter
 *
 * @author vuppala
 */
// @FacesConverter(value = "projectConverter")
@Named
@RequestScoped  // can be applicaoitn scoped
public class ProjectConverter implements Converter {

    @EJB
    private ProjectEJB projectEJB;
    // private static final Logger logger = Logger.getLogger(ProjectConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String stringValue) {
        if (stringValue == null || stringValue.isEmpty()) {
            return null;
        } 
        
        try {
            return projectEJB.findProject(Long.valueOf(stringValue));
        } catch (Exception e){
            throw new ConverterException("Not a valid project ID");
        }      
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelObject) {
        if (modelObject == null) {
            return "";
        }
        
        if (modelObject instanceof Project) {
            return ((Project) modelObject).getId().toString();
        } else {
            throw new ConverterException("Not a valid project");
        }       
    }
}
