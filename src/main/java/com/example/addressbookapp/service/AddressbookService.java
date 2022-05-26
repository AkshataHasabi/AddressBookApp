package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;
import com.example.addressbookapp.exception.AddressbookException;
import com.example.addressbookapp.repository.AddressbookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressbookService implements IAddressbookService {
    @Autowired
    private AddressbookRepository addressbookRepository;

    public List<AddressbookData> getAddressbookData() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressbookData getAddressbookDataById(int id) {
        return addressbookRepository.findById(id).orElseThrow(()-> new AddressbookException("Exception with id"+id+"does not exist!!"));
    }

    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=new AddressbookData(addressbookDTO);
        log.info("Addressbook data:"+addressbookData.toString());
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressbookData updateAddressbookData(int id,AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=this.getAddressbookDataById(id);
        addressbookData.updateAddressbookData(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public void deleteAddressbookData(int id) {
        AddressbookData addressbookData=this.getAddressbookDataById(id);
        addressbookRepository.delete(addressbookData);
    }
}
