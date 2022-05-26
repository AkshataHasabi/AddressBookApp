package com.example.addressbookapp.entity;

import com.example.addressbookapp.dto.AddressbookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "addressbookDetails")
public class AddressbookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressbook_id")
    private int id;
    @Column(name = "firstName")
    private String fName;
    @Column(name = "lastName")
    private String lName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    public void updateAddressbookData(AddressbookDTO addressbookDTO) {
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

    public AddressbookData(AddressbookDTO addressbookDTO){
        this.updateAddressbookData(addressbookDTO);
    }

}
