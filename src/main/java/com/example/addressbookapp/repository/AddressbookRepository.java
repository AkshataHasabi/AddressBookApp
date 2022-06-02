package com.example.addressbookapp.repository;

import com.example.addressbookapp.entity.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressbookRepository extends JpaRepository<AddressbookData,Integer> {
   @Query(value = "select * from addressbook_details where city = city",nativeQuery=true)
   List<AddressbookData> findAddressbookDataByCity(String city);
   @Query(value = "select * from addressbook_details ORDER BY city asc ",nativeQuery=true)
   List<AddressbookData> getAddressbookSortByCity();
   @Query(value = "select * from addressbook_details ORDER BY state desc ",nativeQuery=true)
   List<AddressbookData> getAddressbookSortByState();
}
