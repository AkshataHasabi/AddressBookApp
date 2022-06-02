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
    @Autowired
     private TokenUtil tokenUtil;
    @Autowired
    EmailSenderService sender;

    public List<AddressbookData> getAddressbookData(String token) {
        int id=tokenUtil.decodeToken(token);
        Optional<AddressbookData> isContactPresent=addressbookRepository.findById(id);
        if(isContactPresent.isPresent()) {
            List<AddressbookData> listAddressBook=addressbookRepository.findAll();
            sender.sendEmail("akshuh818@gmail.com", "Test Email", "Get your data with this token, hii: "
                    +isContactPresent.get().getEmail()+"Please Click here to get data-> "
                    +"http://localhost:8081/addressBook/retrieve/"+token);
            return listAddressBook;
        }else {
            System.out.println("Exception ...Token not found!");
            return null;
        }
    }

    @Override
    public AddressbookData getAddressbookDataById(String token) {
        Integer id = tokenUtil.decodeToken(token);
        Optional<AddressbookData> newAddressBook = addressbookRepository.findById(id);
        if(newAddressBook.isPresent()) {
            sender.sendEmail("akshuh818@gmail.com", "Test Email", "Data retrieve SuccessFully, hii: "
                    +newAddressBook.get().getEmail()+"Please Click here to get data-> "
                    +"http://localhost:8080/addressbook/get/"+token);

            return newAddressBook.get();
        }
        else {
            log.warn("Unable to find address book details for given id: "+id);
            throw new AddressbookException("Address Book Details not found for that particular id");
        }
    }

    @Override
    public List<AddressbookData> getAddressbookByCity(String token) {
        String city= String.valueOf(tokenUtil.decodeToken(token));
        List<AddressbookData> isContactPresent=addressbookRepository.findAddressbookDataByCity(city);
        if(isContactPresent.isEmpty()) {
            System.out.println("Exception ...Token not found!");
            return null;
        }else {
            List<AddressbookData> listAddressBook=addressbookRepository.findAll();
            sender.sendEmail("akshuh818@gmail.com", "Test Email", "Get your data with this token, hii: "
                    +isContactPresent.get(0).getEmail()+"Please Click here to get data-> "
                    +"http://localhost:8081/addressBook/retrieve/"+token);
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
        log.info("Addressbook data:"+addressbookData.toString());
        addressbookRepository.save(addressbookData);
        String token = tokenUtil.createToken(addressbookData.getId());
        sender.sendEmail(addressbookData.getEmail(), "Test Email", "Registered SuccessFully, hii : "
                +addressbookData.getFName()+"Please Click here to get data-> "
                +"http://localhost:8080/addressbook/get/"+token);
        return addressbookData;
    }

    @Override
    public AddressbookData updateAddressbookData(String token,AddressbookDTO addressbookDTO) {
        Integer id= tokenUtil.decodeToken(token);
        Optional<AddressbookData> addressbookData =addressbookRepository.findById(id);
        if(addressbookData.isPresent()) {
            AddressbookData addressBookData1= new AddressbookData(id,addressbookDTO);
            addressbookRepository.save(addressBookData1);
            sender.sendEmail(addressBookData1.getEmail(), "Test Email", "Updated SuccessFully, hii: "
                    + addressBookData1.getFName()+"Please Click here to get data of updated id-> "
                    +"http://localhost:8081/addressBook/get/"+token);
            return addressBookData1;

        }
        throw new AddressbookException("Address Book Details for id not found");
    }

    @Override
    public AddressbookData deleteAddressbookData(String token) {
        Integer id = tokenUtil.decodeToken(token);
        Optional<AddressbookData> addressBook = addressbookRepository.findById(id);
        if(addressBook.isPresent())
        {
            addressbookRepository.deleteById(id);
            sender.sendEmail("akshuh818@gmail.com", "Test Email", "Deleted SuccessFully, hii: "
                    +addressBook.get()+"Please Click here to get data-> "
                    +"http://localhost:8080/addressbook/delete/"+token);
        }
        else {
            log.warn("Unable to find address book details for given id: "+id);
            throw new AddressbookException("Address Book Details not found");
        }
        // return "Data is deleted successfully who's user id is "+id;
        return addressBook.get();
    }
}
