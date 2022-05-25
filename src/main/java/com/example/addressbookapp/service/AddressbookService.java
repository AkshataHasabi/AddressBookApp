package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookService implements IAddressbookService {

    public List<AddressbookData> getAddressbookData() {
        List<AddressbookData> employeePayrolDataList=new ArrayList<>();
        employeePayrolDataList.add(new AddressbookData(1,new AddressbookDTO("Vinayak","Hasabi",
                "91+12345","akshu@123","yaragatti","savadatti","karnataka",147852)));
        return employeePayrolDataList;
    }

    @Override
    public AddressbookData getAddressbookDataById(int id) {
        AddressbookData addressbookData=new AddressbookData(2,new AddressbookDTO("Vinayak","Hasabi",
                            "91+12345","akshu@123","yaragatti","savadatti","karnataka",147852));
        return addressbookData;
    }

    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=new AddressbookData(1,addressbookDTO);
        return addressbookData;
    }

    @Override
    public AddressbookData updateAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=new AddressbookData(1,addressbookDTO);
        return addressbookData;
    }

    @Override
    public void deleteAddressbookData(int id) {

    }
}
