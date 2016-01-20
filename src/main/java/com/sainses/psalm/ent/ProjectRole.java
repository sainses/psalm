package com.sainses.psalm.ent;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class ProjectRole implements Serializable {

    @ManyToOne(targetEntity = SysRole.class)
    private SysRole role;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    @Id
    private Long id;

    public ProjectRole() {

    }

    public SysRole getRole() {
        return this.role;
    }

    public void setRole(SysRole role) {
        this.role = role;
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
}
