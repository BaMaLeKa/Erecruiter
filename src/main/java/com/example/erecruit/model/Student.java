package com.example.erecruit.model;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1) //??
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long id;
    private String name;
    private String surname;
    private String birthDate;
    private String birthPlace;
    private String email;

    private String address;
    private String zipcode;
    private String city;
    private String province;

    private String guardName;
    private String guardSurname;
    private String guardTelephone;
    private String guardEmail;

    private String firstChoice;

    private String extension;


//    -------------------------------------------

    public Student() {
    }


    // Konstruktor do formularza z id
    public Student(long id, String name, String surname, String birthDate, String birthPlace, String email,
                   String address, String zipcode, String city, String province,
                   String guardName, String guardSurname, String guardTelephone, String guardEmail,
                   String firstChoice, String extension) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.province = province;
        this.guardName = guardName;
        this.guardSurname = guardSurname;
        this.guardTelephone = guardTelephone;
        this.guardEmail = guardEmail;
        this.firstChoice = firstChoice;
        this.extension = extension;
    }

    // Konstruktor do formularza bez id
    public Student(String name, String surname, String birthDate, String birthPlace, String email,
                   String address, String zipcode, String city, String province,
                   String guardName, String guardSurname, String guardTelephone, String guardEmail,
                   String firstChoice, String extension) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.province = province;
        this.guardName = guardName;
        this.guardSurname = guardSurname;
        this.guardTelephone = guardTelephone;
        this.guardEmail = guardEmail;
        this.firstChoice = firstChoice;
        this.extension = extension;
    }

    //    -------------------------------------------


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGuardName() {
        return guardName;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    public String getGuardSurname() {
        return guardSurname;
    }

    public void setGuardSurname(String guardSurname) {
        this.guardSurname = guardSurname;
    }

    public String getGuardTelephone() {
        return guardTelephone;
    }

    public void setGuardTelephone(String guardTelephone) {
        this.guardTelephone = guardTelephone;
    }

    public String getGuardEmail() {
        return guardEmail;
    }

    public void setGuardEmail(String guardEmail) {
        this.guardEmail = guardEmail;
    }

    public String getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(String firstChoice) {
        this.firstChoice = firstChoice;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", guardName='" + guardName + '\'' +
                ", guardSurname='" + guardSurname + '\'' +
                ", guardTelephone='" + guardTelephone + '\'' +
                ", guardEmail='" + guardEmail + '\'' +
                ", firstChoice=" + firstChoice + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }

}
