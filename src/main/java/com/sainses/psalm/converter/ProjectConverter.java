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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 * Facility converter
 *
 * @author vuppala
 */
@Named    // workaround for injecting an EJB in a converter
// @FacesConverter(value = "facilityConverter")
public class ProjectConverter implements Converter {

    @EJB
    private ProjectEJB projectEJB;
    private static final Logger logger = Logger.getLogger(ProjectConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Project project;

        if (projectEJB == null) {
            logger.log(Level.SEVERE, "EJB is null. Injection did not work.");
            return null;
        }

        if (value == null || value.equals("")) {
            logger.log(Level.FINE, "Empty Project ID");
            return null;
        } else {
            project = projectEJB.findProject(Long.parseLong(value));
            return project;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            logger.log(Level.WARNING, "Null object");
            return null;
        } else {
            // logger.log(Level.FINE, "Exp number: " + ((Experiment) value).getId().toString());
            return ((Project) value).getId().toString();
        }
    }
}
