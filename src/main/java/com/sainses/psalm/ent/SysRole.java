package com.sainses.psalm.ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class SysRole implements Serializable {

    @Column(name = "name", unique = true, nullable = false, length = 64)
    @Basic
    private String name;

    @Column(name = "description")
    @Basic
    private String description;

    @Column(name = "id")
    @Id
    private Long id;

    public SysRole() {

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
