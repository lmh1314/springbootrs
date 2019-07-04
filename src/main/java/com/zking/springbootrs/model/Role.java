package com.zking.springbootrs.model;

import java.io.Serializable;
import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {

    private Integer rid;
    private String rname;
    private Set<User> users=new HashSet<>();
    private Set<Permission> permissions=new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                '}';
    }
}
