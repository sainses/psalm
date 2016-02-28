package com.sainses.psalm.ent;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="sysuser")
@NamedQueries({
    @NamedQuery(name = "SysUser.findAll", query = "SELECT s FROM SysUser s"),
    @NamedQuery(name = "SysUser.findByLoginId", query = "SELECT s FROM SysUser s WHERE s.loginId = :loginId"),
    })
public class SysUser implements Serializable {
    @Column(name="id",nullable=false)
    @Id
    private Long id;

    @Column(name="last_name",nullable=false)
    @Basic
    private String lastName;

    @Column(name="first_name",nullable=false)
    @Basic
    private String firstName;

    @Column(name="password")
    @Basic
    private String password;

    @Column(name="login_id",unique=true,nullable=false,length=64)
    @Basic
    private String loginId;

    @ManyToMany(targetEntity = ProjectRole.class)
    @JoinTable(name="sysuser_project_role",joinColumns={@JoinColumn(name="project_role",referencedColumnName="id",nullable=false)},
            inverseJoinColumns={@JoinColumn(name="sysuser",referencedColumnName="id",nullable=false)})
    private List<ProjectRole> projectRoles;

    @Column(name="description")
    @Basic
    private String description;

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
   
    public List<ProjectRole> getProjectRoles() {
        return this.projectRoles;
    }

    public void setProjectRoles(List<ProjectRole> projectRoles) {
        this.projectRoles = projectRoles;
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
