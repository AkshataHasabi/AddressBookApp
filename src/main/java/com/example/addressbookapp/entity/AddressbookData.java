package com.example.addressbookapp.entity;

import com.example.addressbookapp.dto.AddressbookDTO;
import lombok.Data;

@Data
public class AddressbookData {
    private int id;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    public AddressbookData(int id, AddressbookDTO addressbookDTO) {
        this.id = id;
        this.fName = addressbookDTO.getFName();
        this.lName = addressbookDTO.getLName();
        this.phoneNumber = addressbookDTO.getPhoneNumber();
        this.email = addressbookDTO.getEmail();
        this.address = addressbookDTO.getAddress();
        this.city = addressbookDTO.getCity();
        this.state = addressbookDTO.getState();
        this.zipCode = addressbookDTO.getZipCode();
        this.country=addressbookDTO.getCountry();
    }

    public AddressbookData() {
    }
}
