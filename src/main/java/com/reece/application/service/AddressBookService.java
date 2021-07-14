package com.reece.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reece.application.entity.AddressBook;
import com.reece.application.model.AddressBookModel;
import com.reece.application.model.ReponseModel;
import com.reece.application.repository.AddressBookRepository;

@Service
//@Slf4j
public class AddressBookService {

	@Autowired
	AddressBookRepository addRepo;

	
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AddressBookService.class);

	public List<AddressBookModel> getAllAddressBookDetails() {
		
		try {
			List<AddressBookModel> addBookList = (addRepo.findAll()).stream()
			        .map(address -> new AddressBookModel(address.getCustomerId(),address.getAddName(),address.getPhoneNumber()))
			        .collect(Collectors.toList());
			return addBookList;
		} catch (Exception ex) {
			log.info("Error occured while adding a new address" + ex.getStackTrace());
			return null;
		}

	}
	public List<AddressBookModel> getAddressesByCustomerId(Long customerId) {
		try {
			List<AddressBookModel> addBookList = (addRepo.findByCustomerId(customerId)).stream()
					  .map(address -> new AddressBookModel(address.getCustomerId(),address.getAddName(),address.getPhoneNumber()))
			        .collect(Collectors.toList());
			return addBookList;
		} catch (Exception ex) {
			log.info("Error occured while adding a new address" + ex.getStackTrace());
			return null;
		}
	}
	
	@Transactional
	public ReponseModel addAddress(AddressBookModel addBook) {

		ReponseModel response = new ReponseModel();
		try {
			if (!validateUniqueAddressEntries(addBook)) {
			 response.setResponseMessage("Customer's address name and phone number already exists");
			 return response;

			}
			AddressBook entity = new AddressBook();
			BeanUtils.copyProperties(addBook, entity);
			addRepo.save(entity);
			addBook.setId(entity.getId());

			response.setAdressBook(addBook);
			response.setResponseMessage("Customer's address added successfully");

		} catch (Exception ex) {
			log.info("Error occured while adding a new address" + ex.getStackTrace());
			response.setResponseMessage("Error occured while adding Customer's address");

		}
		return response;
	}
	
	@Transactional
	public boolean deleteAddress(Long id) {
		try {
			addRepo.deleteById(id);
			return true;
		} catch (Exception ex) {
			log.info("Error occured while deleting the address" + ex.getStackTrace());
			return false;
		}

	}

	private boolean validateUniqueAddressEntries(AddressBookModel addBook) {

		List<AddressBook> entities = addRepo.findByCustomerId(addBook.getCustomerId());
		List<AddressBook> entitiesWithSameNamePhoneNumber = entities.stream()
				.filter(e -> e.getAddName().equalsIgnoreCase(addBook.getAddName()) && e.getCustomerId()==addBook.getCustomerId() && e.getPhoneNumber().equalsIgnoreCase(addBook.getPhoneNumber()))
				.collect(Collectors.toList());
		return (entitiesWithSameNamePhoneNumber.isEmpty());
	}
	



}
