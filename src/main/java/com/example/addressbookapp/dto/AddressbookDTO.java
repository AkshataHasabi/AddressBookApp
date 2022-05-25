package com.example.addressbookapp.dto;

public class AddressbookDTO {
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zipCode;

    public AddressbookDTO(String fName, String lName, String phoneNumber, String email, String address, String city, String state, int zipCode) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddressbookDTO{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
