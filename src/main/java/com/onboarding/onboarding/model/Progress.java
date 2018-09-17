package com.onboarding.onboarding.model;

import javax.persistence.*;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean credentialsCompleted;
    private boolean contractSigned;

    @OneToOne
    private Employee employee;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCredentialsCompleted() {
        return credentialsCompleted;
    }

    public void setCredentialsCompleted(boolean credentialsCompleted) {
        this.credentialsCompleted = credentialsCompleted;
    }

    public boolean isContractSigned() {
        return contractSigned;
    }

    public void setContractSigned(boolean contractSigned) {
        this.contractSigned = contractSigned;
    }


}