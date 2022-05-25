package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressbookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.entity.AddressbookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {

    //get addressbook details
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressbookData(){
        AddressbookData addressbookData=new AddressbookData(1,new AddressbookDTO("Akshata","Hasabi","91+12345678",
                                                    "akshu@123","yaragatti","savadatti","karnatak",12345));
        ResponseDTO responseDTO=new ResponseDTO("Get call Success",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //get addressbook details by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable int id){
        AddressbookData addressbookData=new AddressbookData(1,new AddressbookDTO("Akshata","Hasabi","91+12345678",
                "akshu@123","yaragatti","savadatti","karnatak",12345));
        ResponseDTO responseDTO=new ResponseDTO("Get call Success",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //create addressbook details
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData=new AddressbookData(1,addressbookDTO);
        ResponseDTO responseDTO=new ResponseDTO("created Addressbook data succesfully",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //update addressbook details
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData=new AddressbookData(1,addressbookDTO);
        ResponseDTO responseDTO=new ResponseDTO("updated Addressbook data succesfully",addressbookData);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //delete addressbook details by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable int id){
        ResponseDTO responseDTO=new ResponseDTO("deleted succesfully",id);
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
