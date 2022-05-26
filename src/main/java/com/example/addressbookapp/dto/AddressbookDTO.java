package com.example.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressbookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Addressbook author first name pattern is invalid")
    public String fName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Addressbook author last name pattern is invalid")
    public String lName;
    @NotNull(message = "phone number should not be empty")
    public String phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="Email pattern is invalid")
    public String email;
    @NotBlank(message = "address book should not be empty")
    public String address;
    @NotBlank(message = "city should not be empty")
    public String city;
    public String state;
    //@Pattern(regexp = "^[0-9]{5}(-[0-9]{4}?)$",message = "zipcode is invalid")
    public int zipCode;
}
