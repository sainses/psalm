/*
 * The MIT License
 *
 * Copyright 2016 SAInS LLC.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sainses.psalm.view;

import com.sainses.psalm.ejb.ProjectEJB;
import com.sainses.psalm.ent.Project;
import com.sainses.psalm.ent.Task;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * View for Projects
 * 
 * @author vvuppala
 */

@Named
@ViewScoped
public class TaskView implements Serializable {
    private static final String className = TaskView.class.getCanonicalName();
    private static final Logger logger = Logger.getLogger(className);
    
    @EJB
    private ProjectEJB projectEJB;
    
    private List<Task> tasks;
    private Project selectedProject;
    
    @PostConstruct
    private void init() {
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger.logp(Level.INFO, className, methodName, "Postconstruct {0} ", TaskView.class.getName());
        // tasks = projectEJB.getTasks(selectedProject);
    }
    
    public void initTasks() {
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger.logp(Level.INFO, className, methodName, "initializing tasks for project {0}", selectedProject);
        tasks = projectEJB.getTasks(selectedProject);
    }
    // getters and setters

    public List<Task> getTasks() {
        return tasks;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }    
}
