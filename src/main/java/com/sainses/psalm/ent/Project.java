package com.sainses.psalm.ent;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

//public class Project implements Serializable {
public class Project  {

    @Column(nullable = false)
    @Basic
    private String sponsor;

    @Column(nullable = false)
    @Basic
    private String manager;

    @Column(unique = true, nullable = false, length = 64)
    @Basic
    private String name;

    @Column(nullable = false)
    @Basic
    private String description;

    @Column(nullable = false)
    @Basic
    private String client;

    @Column(nullable = false)
    @Id
    private Long id;

    @Column(nullable = false)
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
