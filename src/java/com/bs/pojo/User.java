package com.bs.pojo;
// Generated Sep 4, 2016 8:27:06 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userId;
     private String login;
     private String pwd;
     private Boolean enabled;
     private Set roles = new HashSet(0);

    public User() {
    }

	
    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    public User(String login, String pwd, Boolean enabled, Set roles) {
       this.login = login;
       this.pwd = pwd;
       this.enabled = enabled;
       this.roles = roles;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public Boolean getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Set getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set roles) {
        this.roles = roles;
    }




}


