package com.onboarding.onboarding.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Fillout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition="LONGBLOB")
    private byte[] formData;

    @OneToOne
    private Employee employee;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getFormData() {
        return formData;
    }

    public void setFormData(byte[] formData) {
        this.formData = formData;
    }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) { this.employee = employee; }
}
