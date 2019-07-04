package com.zking.springbootrs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Mypermission implements Serializable {


    private Integer pid;
    private String pname;
    private String url;
    private String permission;
    private Set<Role> roles=new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


    @Override
    public String toString() {
        return "Mypermission{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", roles=" + roles +
                '}';
    }
}
