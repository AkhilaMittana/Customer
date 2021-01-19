package com.example.demo.Customer;

public class CustomerNotFoundException extends Exception {
	private String emailId;
	public CustomerNotFoundException(String emailId) {
        super(String.format("Customer is not found with id : '%s'", emailId));
        }
}
