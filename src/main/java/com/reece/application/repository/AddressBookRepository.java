package com.reece.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reece.application.entity.AddressBook;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long>{

	List<AddressBook> findByCustomerId(Long customerId);

}
