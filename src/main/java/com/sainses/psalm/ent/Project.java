package com.sainses.psalm.ent;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project implements Serializable {

    @Column(name = "sponsor", nullable = false)
    @Basic
    private String sponsor;

    @Column(name = "manager", nullable = false)
    @Basic
    private String manager;

    @Column(name = "name", unique = true, nullable = false, length = 64)
    @Basic
    private String name;

    @Column(name = "description", nullable = false)
    @Basic
    private String description;

    @Column(name = "client", nullable = false)
    @Basic
    private String client;

    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    @Column(name = "start_date", nullable = false)
    @Basic
    private Date startDate;

    public Project() {

    }

    public String getSponsor() {
        return this.sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getManager() {
        return this.manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
