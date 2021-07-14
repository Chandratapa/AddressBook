package com.reece.application.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reece.application.utils.ContactNumberConstraint;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class AddressBookModel implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;

	@NotNull(message = "Customer ID must not be empty")
	private Long customerId;
	@Size(min=1,max = 50, message = "Customer's address name cannot be more than 50 characters")
	@NotEmpty(message = "Customer's address name must not be empty")
	private String addName;

	@Size(min = 10, max = 10, message = "Customer's phone number should be equal to 10 digits")
	@NotEmpty(message = "Phone number must not be empty")
	@ContactNumberConstraint
	private String phoneNumber;

	public AddressBookModel(@NotNull(message = "Customer ID must not be empty") Long customerId,
			@Size(max = 50, message = "Customer's address name cannot be more than 50 characters") @NotEmpty(message = "Customer's address name must not be empty") String addName,
			@Size(min = 10, max = 10, message = "Customer's phone number should be equal to 10 digits") @NotEmpty(message = "Phone number must not be empty") String phoneNumber) {
		super();
		this.customerId = customerId;
		this.addName = addName;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}
	

}
