package com.onboarding.onboarding.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String initials;
    private String callingName;
    private String street;
    private String postalcode;
    private String city;
    private String houseNumberExt;
    private String nationality;
    private String gender;
    private String birthPlace;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String bsn;
    private String maritalState;
    private String dietaryWishes;
    private String bankName;
    private String bankNumber;
    private String bankPersonName;
    private String emergencyPerson;
    private String emergencyNumber;

    private boolean loonheffing;
    private int houseNumber;
    private LocalDate birthDate;

    public HashMap getHashMapData() {
        HashMap<String, String> hashMapData = new HashMap<>();
        hashMapData.put("email", this.email);
        hashMapData.put("firstName", this.firstName);
        hashMapData.put("lastName", this.lastName);
        hashMapData.put("phoneNumber", this.phoneNumber);
        hashMapData.put("initials", this.initials);
        hashMapData.put("callingName", this.callingName);
        hashMapData.put("street", this.street);
        hashMapData.put("postalcode", this.postalcode);
        hashMapData.put("city", this.city);
        hashMapData.put("houseNumberExt", this.houseNumberExt);
        hashMapData.put("nationality", this.nationality);
        hashMapData.put("bsn", this.bsn);
        hashMapData.put("maritalState", this.maritalState);
        hashMapData.put("dietaryWishes", this.dietaryWishes);
        hashMapData.put("bankName", this.bankName);
        hashMapData.put("bankNumber", this.bankNumber);
        hashMapData.put("bankPersonName", this.bankPersonName);
        hashMapData.put("emergencyPerson", this.emergencyPerson);
        hashMapData.put("emergencyNumber", this.emergencyNumber);
        hashMapData.put("loonheffing", this.loonheffing+"");
        hashMapData.put("houseNumber", this.houseNumber+"");
        hashMapData.put("birthDate", this.birthDate+"");
        hashMapData.put("fullName", this.firstName + " " + this.lastName);
        hashMapData.put("gender", gender);
        hashMapData.put("streetHousenumber", this.street + " " + this.houseNumber + "-" + this.houseNumberExt);
        hashMapData.put("birthPlace", birthPlace);

        return hashMapData;



    }

    public YCProgram getYcProgram() {
        return ycProgram;
    }

    public void setYcProgram(YCProgram ycProgram) {
        this.ycProgram = ycProgram;
    }

    @ManyToOne
    private YCProgram ycProgram;

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    @OneToOne
    private Progress progress;

   // @OneToMany
   // private List<Fillout> fillout = new ArrayList<>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getCallingName() {
        return callingName;
    }

    public void setCallingName(String callingName) {
        this.callingName = callingName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumberExt() {
        return houseNumberExt;
    }

    public void setHouseNumberExt(String houseNumberExt) {
        this.houseNumberExt = houseNumberExt;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public String getMaritalState() {
        return maritalState;
    }

    public void setMaritalState(String maritalState) {
        this.maritalState = maritalState;
    }

    public String getDietaryWishes() {
        return dietaryWishes;
    }

    public void setDietaryWishes(String dietaryWishes) {
        this.dietaryWishes = dietaryWishes;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankPersonName() {
        return bankPersonName;
    }

    public void setBankPersonName(String bankPersonName) {
        this.bankPersonName = bankPersonName;
    }

    public String getEmergencyPerson() {
        return emergencyPerson;
    }

    public void setEmergencyPerson(String emergencyPerson) {
        this.emergencyPerson = emergencyPerson;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public boolean isLoonheffing() {
        return loonheffing;
    }

    public void setLoonheffing(boolean loonheffing) {
        this.loonheffing = loonheffing;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return this.gender; }

    public String getBirthPlace() { return this.birthPlace; }

    public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }
}