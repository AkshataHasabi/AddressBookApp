package com.example.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {
    public static void main(String[] args) {
        System.out.println("welcome to AddressBookApp development");
        SpringApplication.run(AddressBookAppApplication.class, args);
        log.info("Employee Payroll App Started");
    }
}
