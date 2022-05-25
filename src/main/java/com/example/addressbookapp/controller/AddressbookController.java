package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressbookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {

    @RequestMapping("/get")
    public ResponseEntity<String> getAddressbookData(){
        return  new ResponseEntity<String>("Get call Success", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressbookData(@PathVariable int id){
        return  new ResponseEntity<String>("Get call Success for id"+id, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO){
        return  new ResponseEntity<String>("created Addressbook data for"+addressbookDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddressbookData(@RequestBody AddressbookDTO addressbookDTO){
        return  new ResponseEntity<String>("updated Addressbook data for"+addressbookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressbookData(@PathVariable int id){
        return  new ResponseEntity<String>("delete call Success for id"+id, HttpStatus.OK);
    }

}
