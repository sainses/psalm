package com.sainses.psalm.ent;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")

public class Task implements Serializable {

    @Column(name = "duration")
    @Basic
    private Integer duration;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Task.class)
    @JoinTable(joinColumns = {
        @JoinColumn(name = "predecessors", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "successors", referencedColumnName = "id")})
    private Task predecessorTasks;

    @Column(name = "task_type", nullable = false)
    @Basic
    private String taskType;

    @Column(name = "end_date")
    @Basic
    private Date endDate;

    @OneToOne(targetEntity = Task.class)
    @JoinColumn(name = "parent", referencedColumnName = "id")
    private Task parentTask;

    @Column(nullable = false)
    @Basic
    private String description;

    @ManyToMany(targetEntity = Resource.class, mappedBy = "tasks")
    private Collection<Resource> resources;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project", nullable = false)
    private Project project;

    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    @Column(name = "wbs_number", unique = true)
    @Basic
    private String WBSnumber;

    @Column(name = "start_date")
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

    public String getTaskType() {
        return this.taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
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

    public String getWBSnumber() {
        return this.WBSnumber;
    }

    public void setWBSnumber(String WBSnumber) {
        this.WBSnumber = WBSnumber;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
