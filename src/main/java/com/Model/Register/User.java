package com.Model.Register;

public class User {

    private String name;
    private Long phoneNo;
    private String email;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
