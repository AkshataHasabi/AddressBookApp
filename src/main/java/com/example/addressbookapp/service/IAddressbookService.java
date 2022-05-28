package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;

import java.util.List;

public interface IAddressbookService {
    List<AddressbookData> getAddressbookData();
    AddressbookData getAddressbookDataById(int id);
    List<AddressbookData> getAddressbookByCity(String city);
    List<AddressbookData> getAddressbookSortByCity(String city);
    List<AddressbookData> getAddressbookSortByState(String state);
    AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);
    AddressbookData updateAddressbookData( int id, AddressbookDTO addressbookDTO);
    void deleteAddressbookData(int id);
}
