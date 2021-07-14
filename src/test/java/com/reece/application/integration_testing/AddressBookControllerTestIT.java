package com.reece.application.integration_testing;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.reece.application.controller.AddressBookController;
import com.reece.application.repository.AddressBookRepository;
import com.reece.application.service.AddressBookService;

@ContextConfiguration(classes = { AddressBookController.class, AddressBookService.class })
@WebMvcTest(AddressBookController.class)

class AddressBookControllerTestIT {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AddressBookRepository addRepo;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach()
	public void setup()
	{
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@WithMockUser(value = "test")
	@Test
	void testGetAllAddressBookDetails() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/addressBook/allAddresses");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"addList\":[]}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}
	
	@WithMockUser(value = "test")
	@Test
	void testGetAddressesByCustomerId() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/addressBook/getAddressesByCustomerId/1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"addList\":[]}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@WithMockUser(value = "test")
	@Test
	void testAddAddress() throws Exception {
		String custAddBookJson = "{\"customerId\":1,\"addName\":\"Rajib\",\"phoneNumber\":\"1234567890\"}";	
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addressBook/addAddress").accept(MediaType.APPLICATION_JSON).content(custAddBookJson)
				.contentType(MediaType.APPLICATION_JSON);;
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"adressBook\":{\"customerId\":1,\"addName\":\"Rajib\",\"phoneNumber\":\"1234567890\"},\"responseMessage\":\"Customer's address added successfully\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
				  	

	}
	
	@WithMockUser(value = "test")
	@Test
	void testDeleteAddress() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/addressBook/deleteAddress/1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "Successfully deleted the address";
		assertEquals(null,expected, result.getResponse().getContentAsString());
	}

}
