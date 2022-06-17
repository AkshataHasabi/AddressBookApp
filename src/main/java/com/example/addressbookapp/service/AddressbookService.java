package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.entity.AddressbookData;
import com.example.addressbookapp.exception.AddressbookException;
import com.example.addressbookapp.repository.AddressbookRepository;
import com.example.addressbookapp.util.EmailSenderService;
import com.example.addressbookapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressbookService implements IAddressbookService {
    @Autowired
    private AddressbookRepository addressbookRepository;

    public List<AddressbookData> getAddressbookData() {
            List<AddressbookData> listAddressBook=addressbookRepository.findAll();
            return listAddressBook;
    }

    @Override
    public AddressbookData getAddressbookDataById(int id) {
        Optional<AddressbookData> newAddressBook = addressbookRepository.findById(id);
        if(newAddressBook.isPresent()) {
           return newAddressBook.get();
        }
        else {
            log.warn("Unable to find address book details for given id: "+id);
            throw new AddressbookException("Address Book Details not found for that particular id");
        }
    }

    @Override
    public List<AddressbookData> getAddressbookByCity(String city) {
        List<AddressbookData> isContactPresent=addressbookRepository.findAddressbookDataByCity(city);
        if(isContactPresent.isEmpty()) {
            System.out.println("Exception ...Token not found!");
            return null;
        }else {
            List<AddressbookData> listAddressBook=addressbookRepository.findAll();
            return listAddressBook;
        }
    }

    @Override
    public List<AddressbookData> getAddressbookSortByCity() {
        return addressbookRepository.getAddressbookSortByCity();
    }

    @Override
    public List<AddressbookData> getAddressbookSortByState() {
        return addressbookRepository.getAddressbookSortByState();
    }


    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData=new AddressbookData(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressbookData updateAddressbookData(int id,AddressbookDTO addressbookDTO) {
        Optional<AddressbookData> addressbookData =addressbookRepository.findById(id);
        if(addressbookData.isPresent()) {
            AddressbookData addressBookData1= new AddressbookData(id,addressbookDTO);
            return addressbookRepository.save(addressBookData1);
        }
        throw new AddressbookException("Address Book Details for id not found");
    }

    @Override
    public AddressbookData deleteAddressbookData(int id) {
        Optional<AddressbookData> addressBook = addressbookRepository.findById(id);
        if(addressBook.isPresent())
        {
            addressbookRepository.deleteById(id);
        }
        else {
            log.warn("Unable to find address book details for given id: "+id);
            throw new AddressbookException("Address Book Details not found");
        }
        // return "Data is deleted successfully who's user id is "+id;
        return addressBook.get();
    }
}
