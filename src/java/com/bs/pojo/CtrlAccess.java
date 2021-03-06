package com.bs.pojo;
// Generated Sep 4, 2016 8:27:06 PM by Hibernate Tools 4.3.1



/**
 * CtrlAccess generated by hbm2java
 */
public class CtrlAccess  implements java.io.Serializable {


     private Integer ctlId;
     private Employee employee;
     private Login login;
     private String empName;
     private String userRole;
     private String status;

    public CtrlAccess() {
    }

    public CtrlAccess(Employee employee, Login login, String empName, String userRole, String status) {
       this.employee = employee;
       this.login = login;
       this.empName = empName;
       this.userRole = userRole;
       this.status = status;
    }
   
    public Integer getCtlId() {
        return this.ctlId;
    }
    
    public void setCtlId(Integer ctlId) {
        this.ctlId = ctlId;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Login getLogin() {
        return this.login;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }
    public String getEmpName() {
        return this.empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getUserRole() {
        return this.userRole;
    }
    
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


