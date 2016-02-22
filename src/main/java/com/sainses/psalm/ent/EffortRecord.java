package com.sainses.psalm.ent;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class EffortRecord implements Serializable {

    @Column(name = "hours")
    @Basic
    private Float hours;

    @ManyToOne(targetEntity = Task.class)
    @JoinColumn(name = "task", referencedColumnName = "id")
    private Task task;

    @ManyToOne(targetEntity = Resource.class)
    @JoinColumn(name = "resource", referencedColumnName = "id", nullable = false)
    private Resource resource;

    @Column(name = "entered_at", nullable = false)
    @Basic
    private Timestamp enteredAt;

    @Column(name = "comment", length = 2048)
    @Basic
    private String comment;

    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    @Column(name = "effort_date", nullable = false)
    @Basic
    private Date effortDate;

    public EffortRecord() {

    }

    public Float getHours() {
        return this.hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Timestamp getEnteredAt() {
        return this.enteredAt;
    }

    public void setEnteredAt(Timestamp enteredAt) {
        this.enteredAt = enteredAt;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEffortDate() {
        return this.effortDate;
    }

    public void setEffortDate(Date effortDate) {
        this.effortDate = effortDate;
    }
}
