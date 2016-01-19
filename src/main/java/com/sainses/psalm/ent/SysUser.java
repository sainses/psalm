package com.sainses.psalm.ent;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class SysUser implements Serializable {

    @Column(nullable = false)
    @Basic
    private String lastName;

    @Column(nullable = false)
    @Basic
    private String firstName;

    @Basic
    private String password;

    @Column(unique = true, nullable = false, length = 64)
    @Basic
    private String loginId;

    @ManyToMany(targetEntity = ProjectRole.class)
    private Collection<ProjectRole> projectRole;

    @Basic
    private String description;

    @Column(nullable = false)
    @Id
    private Long id;

    public SysUser() {

    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Collection<ProjectRole> getProjectRole() {
        return this.projectRole;
    }

    public void setProjectRole(Collection<ProjectRole> projectRole) {
        this.projectRole = projectRole;
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
