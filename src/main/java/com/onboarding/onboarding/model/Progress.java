package com.onboarding.onboarding.model;

import javax.persistence.*;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private int stage; // 0 -> employee created, 1 -> employee invited, 2 -> forms downloaded, 3-> forms uploaded
//    private boolean employeeInvited;
//    private boolean formsUploaded;

//    @OneToOne
//    private Employee employee;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    //    public boolean isEmployeeInvited() {
//        return employeeInvited;
//    }
//
//    public void setEmployeeInvited(boolean employeeInvited) {
//        this.employeeInvited = employeeInvited;
//    }
//
//    public boolean isFormsUploaded() {
//        return formsUploaded;
//    }
//
//    public void setFormsUploaded(boolean formsUploaded) {
//        this.formsUploaded = formsUploaded;
//    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
}