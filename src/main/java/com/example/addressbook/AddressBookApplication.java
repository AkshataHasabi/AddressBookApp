package com.example.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {
    public static void main(String[] args) {
        System.out.println("welcome to AddressBookApp development");
        ApplicationContext context=SpringApplication.run(AddressBookApplication.class, args);
        log.info("Address book started {} environment",context.getEnvironment().getProperty("environment"));
    }
}
