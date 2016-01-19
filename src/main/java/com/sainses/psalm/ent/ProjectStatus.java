package com.sainses.psalm.ent;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class ProjectStatus implements Serializable {

    @Basic
    private Date statusDate;

    @ManyToOne(targetEntity = Task.class)
    private Task task;

    @Basic
    private Timestamp enteredAt;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    @Id
    private Long id;

    @Basic
    private Float percentComplete;

    @Basic
    private String enteredBy;

    public ProjectStatus() {

    }

    public Date getStatusDate() {
        return this.statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Timestamp getEnteredAt() {
        return this.enteredAt;
    }

    public void setEnteredAt(Timestamp enteredAt) {
        this.enteredAt = enteredAt;
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

    public Float getPercentComplete() {
        return this.percentComplete;
    }

    public void setPercentComplete(Float percentComplete) {
        this.percentComplete = percentComplete;
    }

    public String getEnteredBy() {
        return this.enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }
}
