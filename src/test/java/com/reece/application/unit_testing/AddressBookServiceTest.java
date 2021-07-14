package com.reece.application.unit_testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.reece.application.entity.AddressBook;
import com.reece.application.model.AddressBookModel;
import com.reece.application.model.ReponseModel;
import com.reece.application.repository.AddressBookRepository;
import com.reece.application.service.AddressBookService;

@RunWith(MockitoJUnitRunner.class)
class AddressBookServiceTest {
	
	@InjectMocks
	private AddressBookService service;
	@Spy
	AddressBookRepository addressBookRepository;
	
	@BeforeEach()
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetAllAddressBookDetails() {
		List addBookList = new ArrayList<>();
		Mockito.when(addressBookRepository.findAll()).thenReturn(addBookList);
		assertNotNull(service.getAllAddressBookDetails());
		
	}

	@Test
	void testGetAddressesByCustomerId() {
		List addBookList = new ArrayList<>();
		Mockito.when(addressBookRepository.findByCustomerId(1L)).thenReturn(addBookList);
		assertNotNull(service.getAllAddressBookDetails());
	}

	@Test
	void testAddAddress() {
		AddressBook addBook = new AddressBook();
		addBook.setCustomerId(1L);
		addBook.setAddName("Rajib");
		addBook.setPhoneNumber("12345678");
		ReponseModel model = new ReponseModel();
		AddressBookModel addBookModel = new AddressBookModel(1L,"Rajib","12345678");
		model.setAdressBook(addBookModel);
		model.setResponseMessage("Customer's address added successfully");
		Mockito.when(addressBookRepository.save(addBook)).thenReturn(addBook);
		assertNotNull(service.addAddress(addBookModel));
	}

	@Test
	void testDeleteAddress() {
		boolean result = service.deleteAddress(1L);
		assertNotNull(result);
		assertEquals(true, result);
	}

}
