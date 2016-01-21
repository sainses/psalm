package com.sainses.psalm.ent;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Task implements Serializable {

    @Basic
    private Integer duration;

    @ManyToOne(targetEntity = Task.class)
    private Task predecessorTasks;

    @Basic
    private Date endDate;

    @OneToOne(targetEntity = Task.class)
    private Task parentTask;

    @Basic
    private Integer work;

    @Column(nullable = false)
    @Basic
    private String description;

    @ManyToMany(targetEntity = Resource.class, mappedBy = "tasks")
    private Collection<Resource> resources;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    @Column(nullable = false)
    @Id
    private Long id;

    @Column(nullable = false)
    @Basic
    private String type;

    @Column(nullable = false)
    @Basic
    private String WBSnumber;
    
    @Basic
    private Date startDate;

    public Task() {

    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Task getPredecessorTasks() {
        return this.predecessorTasks;
    }

    public void setPredecessorTasks(Task predecessorTasks) {
        this.predecessorTasks = predecessorTasks;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Task getParentTask() {
        return this.parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public Integer getWork() {
        return this.work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Resource> getResources() {
        return this.resources;
    }

    public void setResources(Collection<Resource> resources) {
        this.resources = resources;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
