package com.reece.application.unit_testing;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.reece.application.controller.AddressBookController;
import com.reece.application.model.AddressBookModel;
import com.reece.application.model.AddressListModel;
import com.reece.application.model.ReponseModel;
import com.reece.application.service.AddressBookService;

@RunWith(MockitoJUnitRunner.class)
class AddressBookControllerTest {

	@InjectMocks
	private AddressBookController controller;
	@Mock
	AddressBookService addressBookService;


	@BeforeEach()
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllAddressBookDetails() {
		List<AddressBookModel> list = new ArrayList<AddressBookModel>();
		Mockito.when(addressBookService.getAllAddressBookDetails()).thenReturn(list);
		ResponseEntity<AddressListModel> response = null;
		response = controller.getAllAddressBookDetails();
		assertNotNull(response);
	}

	@Test
	void testGetAddressesByCustomerId() {
		List<AddressBookModel> list = new ArrayList<AddressBookModel>();
		Mockito.when(addressBookService.getAddressesByCustomerId(1L)).thenReturn(list);
		ResponseEntity<AddressListModel> response = null;
		response = controller.getAddressesByCustomerId(1L);
		assertNotNull(response);
	}

	@Test
	void testAddAddress() {
		AddressBookModel model = new AddressBookModel(1L,"Rajib","12345678");
		ReponseModel responseModel= new ReponseModel();
		Mockito.when(addressBookService.addAddress(model)).thenReturn(responseModel);
		ResponseEntity<ReponseModel> response = null;
		response = controller.addAddress(model);
		assertNotNull(response);
	}

	@Test
	void testDeleteAddress() {
		Mockito.when(addressBookService.deleteAddress(1L)).thenReturn(true);
		ResponseEntity<String> response = null;
		response = controller.deleteAddress(1L);
		assertNotNull(response);
	}

}
