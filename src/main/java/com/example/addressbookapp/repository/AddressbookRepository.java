package com.example.addressbookapp.repository;

import com.example.addressbookapp.entity.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<AddressbookData,Integer> {
}
