package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;

import java.util.List;

public interface IAddressbookService {
    List<AddressbookData> getAddressbookData();
    AddressbookData getAddressbookDataById(int id);
    AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);
    AddressbookData updateAddressbookData(AddressbookDTO addressbookDTO);
    void deleteAddressbookData(int id);
}
