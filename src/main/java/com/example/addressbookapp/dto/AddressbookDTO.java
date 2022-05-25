package com.example.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressbookDTO {
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zipCode;
}
