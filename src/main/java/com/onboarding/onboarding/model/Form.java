package com.onboarding.onboarding.model;

import org.hibernate.sql.ordering.antlr.ColumnReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name; // name.pdf
    private String companyOfForm;


    @Column(columnDefinition="LONGBLOB")
    private byte[] formData;

    @Column(columnDefinition="LONGBLOB")
    private byte[] formConfigPDF;


    @OneToMany
    private List<Fillout> fillouts = new ArrayList<>();

    public String getCompanyOfForm() {
        return companyOfForm;
    }

    public void setCompanyOfForm(String companyOfForm) {
        this.companyOfForm = companyOfForm;
    }

    public YCProgram getProgram() {
        return program;
    }

    public void setProgram(YCProgram program) {
        this.program = program;
    }

    @OneToOne
    private YCProgram program;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public byte[] getFormData() {
        return formData;
    }

    public void setFormData(byte[] formData) {
        this.formData = formData;
    }

    public byte[] getFormConfigPDF() {
        return formConfigPDF;
    }

    public void setFormConfigPDF(byte[] formConfigPDF) {
        this.formConfigPDF = formConfigPDF;
    }

    public List<Fillout> getFillouts() {
        return fillouts;
    }

    public void setFillouts(List<Fillout> fillouts) {
        this.fillouts = fillouts;
    }

    public String getCompanyOftheFrom() {
        return companyOfForm;
    }

    public void setCompanyOftheFrom(String companyOftheFrom) {
        this.companyOfForm = companyOftheFrom;
    }
}
