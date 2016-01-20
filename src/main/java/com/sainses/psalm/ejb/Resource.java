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
package com.sainses.psalm.ejb;

import com.sainses.psalm.ent.Project;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author vvuppala
 */
@Stateless
public class Resource {

    private static final Logger logger = Logger.getLogger(Resource.class.getName());
    @PersistenceContext(unitName = "psalm-data")
    private EntityManager em;

    /**
     * Get a list of all the projects
     * 
     * @return list of projects 
     */
    public List<Resource> getAllProjects() {
        TypedQuery query = em.createQuery("select p from Resource p", Resource.class);
        List<Resource> resources = query.getResultList();
        logger.log(Level.INFO, "Number of resources returned: {0}", resources == null? null : resources.size());

        return resources;
    }
}
