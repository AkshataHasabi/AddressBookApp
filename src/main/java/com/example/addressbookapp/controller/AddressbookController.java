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
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getAddressbookData(){
        List<AddressbookData> addressbookData =iAddressbookService.getAddressbookData();
        ResponseDTO responseDTO=new ResponseDTO("Get call Success",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //get addressbook details by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getAddressbookDataById(@PathVariable int id){
        AddressbookData addressbookData=iAddressbookService.getAddressbookDataById(id);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success for id successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //get addressbook details by their cityname
    @GetMapping("city/{city}")
    public ResponseEntity<ResponseDTO> getAddressbookDataByCity(@PathVariable String city){
       List<AddressbookData> addressbookData=iAddressbookService.getAddressbookByCity(city);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success  for city name successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //sort addressbook by city names
    @GetMapping("sort/{city}")
    public ResponseEntity<ResponseDTO> getAddressbookSortByCity(@PathVariable String city){
        List<AddressbookData> addressbookData=iAddressbookService.getAddressbookSortByCity(city);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success  for city name successfull",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //sort addressbook by state names
    @GetMapping("sort1/{state}")
    public ResponseEntity<ResponseDTO> getAddressbookSortByState(@PathVariable String state){
        List<AddressbookData> addressbookData=iAddressbookService.getAddressbookSortByState(state);
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
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int id,@Valid @RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData=iAddressbookService.updateAddressbookData(id,addressbookDTO);
        ResponseDTO responseDTO=new ResponseDTO("updated Addressbook data succesfully",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //delete addressbook details by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable int id){
        iAddressbookService.deleteAddressbookData(id);
        ResponseDTO responseDTO=new ResponseDTO("deleted succesfully",id);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
