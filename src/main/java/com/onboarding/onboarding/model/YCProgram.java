package com.onboarding.onboarding.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class YCProgram {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String programName;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Form> forms = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }
}
