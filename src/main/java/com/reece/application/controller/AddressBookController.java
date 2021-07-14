package com.reece.application.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reece.application.model.AddressBookModel;
import com.reece.application.model.AddressListModel;
import com.reece.application.model.ReponseModel;
import com.reece.application.service.AddressBookService;

@RestController
@RequestMapping("/addressBook")
//@Slf4j

public class AddressBookController {
	
	@Autowired
	AddressBookService addressBookService;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AddressBookController.class);
	
	@GetMapping("/allAddresses")
	public @ResponseBody ResponseEntity<AddressListModel> getAllAddressBookDetails() {
		log.info("Inside getAllAddressBookDetails of AddressBookController");
		AddressListModel addressListModel = new AddressListModel();
		addressListModel.setAddList(addressBookService.getAllAddressBookDetails());
		return new ResponseEntity<AddressListModel>(addressListModel, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAddressesByCustomerId/{id}")
	public @ResponseBody ResponseEntity<AddressListModel> getAddressesByCustomerId(@PathVariable @Min(1) Long id) {
		log.info("Inside getAllAddressBookDetails of AddressBookController");
		AddressListModel addressListModel = new AddressListModel();
		addressListModel.setAddList(addressBookService.getAddressesByCustomerId(id));
		return new ResponseEntity<AddressListModel>(addressListModel, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/addAddress", consumes = "application/json", produces = "application/json")
	public  @ResponseBody ResponseEntity<ReponseModel> addAddress(@Valid @RequestBody AddressBookModel custAddBook) {
		log.info("Inside addAddress of AddressBookController");	
		return new ResponseEntity<ReponseModel>(addressBookService.addAddress(custAddBook), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public  @ResponseBody ResponseEntity<String> deleteAddress(@PathVariable @Min(1) Long id) {
		log.info("Inside deleteAddress of AddressBookController");		
		return new ResponseEntity<String>((addressBookService.deleteAddress(id)?"Successfully deleted the address":"Failed to delete the address"), HttpStatus.OK);
		
	}

}
