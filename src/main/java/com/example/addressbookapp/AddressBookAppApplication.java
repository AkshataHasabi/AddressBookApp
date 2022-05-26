package com.example.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {
    public static void main(String[] args) {
        System.out.println("welcome to AddressBookApp development");
        ApplicationContext context=SpringApplication.run(AddressBookAppApplication.class, args);
        log.info("Employee payrollapp started {} environment",context.getEnvironment().getProperty("environment"));
    }
}
