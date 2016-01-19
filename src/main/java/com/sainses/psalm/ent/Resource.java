package com.sainses.psalm.ent;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity

public class Resource implements Serializable {

    @Basic
    private float rate;

    @Basic
    private String resType;

    @Basic
    private String name;

    @Basic
    private float maxUnits;

    @Id
    private Long id;

    @OneToOne(targetEntity = SysUser.class)
    private SysUser sysUser;

    @ManyToMany(targetEntity = Task.class)
    private Collection<Task> tasks;

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

    public Collection<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }
}
