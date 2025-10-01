package com.example.project;

public class UserData extends SignUpData { // take user details and preferences
    private String email;
    private String gender;
    private String religion;
    private String education;
    private String maritalStatus;

    private String prefReligion;
    private String prefEducation;
    private String prefMaritalStatus;

    public UserData(String username, String password, String email, String gender, String religion, String education, String maritalStatus) {
        super(username,password);
        this.email = email;
        this.gender = gender;
        this.religion = religion;
        this.education = education;
        this.maritalStatus = maritalStatus;

    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getReligion() {
        return religion;
    }

    public String getEducation() {
        return education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getPrefReligion() {
        return prefReligion;
    }
    public String getPrefEducation() {
        return prefEducation;
    }
    public String getPrefMaritalStatus() {
        return prefMaritalStatus;
    }
    public String getPreferredGender() {
        return gender.equalsIgnoreCase("Male") ? "Female" : "Male";
    }

    public void setPrefReligion(String prefReligion) {
        this.prefReligion = prefReligion;
    }

    public void setPrefEducation(String prefEducation) {
        this.prefEducation = prefEducation;
    }

    public void setPrefMaritalStatus(String prefMaritalStatus) {
        this.prefMaritalStatus = prefMaritalStatus;
    }
}
