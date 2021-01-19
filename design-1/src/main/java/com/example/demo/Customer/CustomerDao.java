package com.example.demo.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerDao{
	@Autowired
	CustomerRepository customerRepository;
	public void customerInsert(Customer c) {
		customerRepository.save(c);
	}
	public void customerUpdate(Customer c) {
		customerRepository.save(c);
	}
	public void customerDelete(int custid) {
		customerRepository.deleteById(custid);
	}
	public List<Customer> customergetAll() {
		return customerRepository.findAll();
	}
	public Optional<Customer> customergetById(int custid) {
		return customerRepository.findById(custid);
	}
	public List<Customer> customerexportAll() {
		return customerRepository.findAll();
	}
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}