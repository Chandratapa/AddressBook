package com.reece.application.integration_testing;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.reece.application.entity.AddressBook;
import com.reece.application.repository.AddressBookRepository;

@DataJpaTest
class AddressBookRepositoryIT {
	@Autowired
	AddressBookRepository addressBookRepository;

	@Test
	public void addAddressBook() {
		AddressBook entity = new AddressBook();
		entity.setId(1L);
		entity.setCustomerId(1L);
		entity.setAddName("Rajib");
		entity.setPhoneNumber("12345678");
		addressBookRepository.save(entity);

		Assert.assertNotNull(entity.getId());
	}

	@Test
	public void getAllAddressBook() {

		List<AddressBook> entities = addressBookRepository.findAll();
		Assert.assertNotNull(entities);
	}

}
