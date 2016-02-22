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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resource")

public class Resource implements Serializable {

    @Column(name = "rate")
    @Basic
    private float rate;

    @Column(name = "res_type")
    @Basic
    private String resType;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "max_units")
    @Basic
    private float maxUnits;

    @Column(name = "id")
    @Id
    private Long id;

    @OneToOne(targetEntity = SysUser.class)
    @JoinColumn(name = "sysuser", referencedColumnName = "id", nullable = false)
    private SysUser sysUser;

    @ManyToMany(targetEntity = Task.class)
    @JoinTable(joinColumns = {
        @JoinColumn(name = "tasks", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "resources", referencedColumnName = "id")})
    private List<Task> tasks;

    public Resource() {

    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getResType() {
        return this.resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMaxUnits() {
        return this.maxUnits;
    }

    public void setMaxUnits(float maxUnits) {
        this.maxUnits = maxUnits;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SysUser getSysUser() {
        return this.sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
