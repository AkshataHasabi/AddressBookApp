package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;

import java.util.List;

public interface IAddressbookService {
    List<AddressbookData> getAddressbookData(String token);
    AddressbookData getAddressbookDataById(String token);
    List<AddressbookData> getAddressbookByCity(String token);
    List<AddressbookData> getAddressbookSortByCity();
    List<AddressbookData> getAddressbookSortByState();
    AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);
    AddressbookData updateAddressbookData(String token, AddressbookDTO addressbookDTO);
    AddressbookData deleteAddressbookData(String token);
}
