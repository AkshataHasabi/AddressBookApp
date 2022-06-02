package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.entity.AddressbookData;
import com.example.addressbookapp.service.IAddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {
    @Autowired
    private IAddressbookService iAddressbookService;

    //get addressbook details
    @GetMapping( "/get/{token}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable String token){
        List<AddressbookData> addressbookData =iAddressbookService.getAddressbookData(token);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //get addressbook details by id
    @GetMapping("/{token}")
    public ResponseEntity<ResponseDTO> getAddressbookDataById(@PathVariable String token){
        AddressbookData addressbookData=iAddressbookService.getAddressbookDataById(token);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success for id successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //get addressbook details by their cityname
    @GetMapping("city/{token}")
    public ResponseEntity<ResponseDTO> getAddressbookDataByCity(@PathVariable String token){
       List<AddressbookData> addressbookData=iAddressbookService.getAddressbookByCity(token);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success  for city name successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //sort addressbook by city names
    @GetMapping("sortcity")
    public ResponseEntity<ResponseDTO> getAddressbookSortByCity(){
        List<AddressbookData> addressbookData=iAddressbookService.getAddressbookSortByCity();
        ResponseDTO responseDTO=new ResponseDTO("Get call Success  for city name successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //sort addressbook by state names
    @GetMapping("sortstate")
    public ResponseEntity<ResponseDTO> getAddressbookSortByState(){
        List<AddressbookData> addressbookData=iAddressbookService.getAddressbookSortByState();
        ResponseDTO responseDTO=new ResponseDTO("Get call Success  for state name successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //create addressbook details
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData=iAddressbookService.createAddressbookData(addressbookDTO);
        ResponseDTO responseDTO=new ResponseDTO("created Addressbook data succesfully",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //update addressbook details
    @PutMapping("/update/{token}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable String token,@Valid @RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData=iAddressbookService.updateAddressbookData(token,addressbookDTO);
        ResponseDTO responseDTO=new ResponseDTO("updated Addressbook data succesfully",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //delete addressbook details by id
    @DeleteMapping("/{token}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable String token){
        ResponseDTO responseDTO=new ResponseDTO("deleted succesfully", iAddressbookService.deleteAddressbookData(token));
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
