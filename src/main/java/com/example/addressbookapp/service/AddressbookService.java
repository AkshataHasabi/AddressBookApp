package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;
import com.example.addressbookapp.exception.AddressbookException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookService implements IAddressbookService {
    private List<AddressbookData> addressbookDataList=new ArrayList<>();

    public List<AddressbookData> getAddressbookData() {
        return addressbookDataList;
    }

    @Override
    public AddressbookData getAddressbookDataById(int id) {
        return addressbookDataList.stream().filter(addressbookData -> addressbookData.getId() == id)
                .findFirst().orElseThrow(()-> new AddressbookException("Exception Not Found!!"));
    }

    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=new AddressbookData(addressbookDataList.size()+1,addressbookDTO);
        addressbookDataList.add(addressbookData);
        return addressbookData;
    }

    @Override
    public AddressbookData updateAddressbookData(int id,AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=this.getAddressbookDataById(id);
        addressbookData.setFName(addressbookDTO.getFName());
        addressbookData.setLName(addressbookDTO.getLName());
        addressbookData.setPhoneNumber(addressbookData.getPhoneNumber());
        addressbookData.setEmail(addressbookData.getEmail());
        addressbookData.setAddress(addressbookDTO.getAddress());
        addressbookData.setCity(addressbookData.getCity());
        addressbookData.setState(addressbookData.getState());
        addressbookData.setZipCode(addressbookDTO.getZipCode());
        addressbookData.setBookName(addressbookDTO.getBookName());
        addressbookDataList.set(id-1,addressbookData);
        return addressbookData;
    }

    @Override
    public void deleteAddressbookData(int id) {
        addressbookDataList.remove(id-1);
    }
}
