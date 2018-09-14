package com.onboarding.onboarding.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Fillout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private byte[] generatedFormData;
    private byte[] generatedFormDataSigned;

    private boolean downloaded;
    private boolean uploaded;
    private boolean approvedByManager;

    private LocalDateTime downloadTime;
    private LocalDateTime uploadTime;

    @OneToOne
    private Employee employee;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getGeneratedFormData() {
        return generatedFormData;
    }

    public void setGeneratedFormData(byte[] generatedFormData) {
        this.generatedFormData = generatedFormData;
    }

    public byte[] getGeneratedFormDataSigned() {
        return generatedFormDataSigned;
    }

    public void setGeneratedFormDataSigned(byte[] generatedFormDataSigned) {
        this.generatedFormDataSigned = generatedFormDataSigned;
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public boolean isApprovedByManager() {
        return approvedByManager;
    }

    public void setApprovedByManager(boolean approvedByManager) {
        this.approvedByManager = approvedByManager;
    }

    public LocalDateTime getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(LocalDateTime downloadTime) {
        this.downloadTime = downloadTime;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
