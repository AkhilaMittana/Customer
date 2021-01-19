package com.example.demo.Customer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
	@Autowired(required=true)
	CustomerDao customerDao;
	
	//Get All Customers
	@GetMapping("/getAll")
	public List <Customer> getAllCustomer(){
		return customerDao.customergetAll();
		}
	//Export All Customers
		@GetMapping("/export")
		public List <Customer> customerexportAll() throws Exception{
			List <Customer> customer = customerDao.customergetAll();
			FileWriter fw = new FileWriter("C:/Users/Akhila Mittana/OneDrive/Desktop/screenshots/customer1.json");
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			
			for(Customer c : customer) {
				JSONObject record = new JSONObject();
		         //Inserting key-value pairs into the json object
		         record.put("ID", c.getCustid());
		         record.put("Name", c.getCustomerName());
		         record.put("Mobile", c.getCustomerMobile());
		         record.put("Email", c.getCustomerEmail());
		         array.put(record);	
			}
			jsonObject.put("Players_data", array);
			fw.write(jsonObject.toString());
			return customer;
			}
	//Get Customers By Id
		@GetMapping("/getId/{custid}")
		public Optional<Customer> getCustomerId(@PathVariable(value = "custid")int custid) {
			return customerDao.customergetById(custid);
		}
		
		@PutMapping("/update")
		public String updateCustomer(@RequestBody Customer customer) {
			customerDao.customerUpdate(customer);
			return "update successful";
		}
		@PostMapping("/insert")
		public String insertCustomer(@RequestBody Customer customer) throws Exception {
			customerDao.customerInsert(customer);
			return "insertion successful";
		}
		
		@DeleteMapping("/delete/{custid}")
		public String deleteCustomer(@PathVariable(value = "custid")int custid) {
			customerDao.customerDelete(custid);
			return "delete successful";
		}
		
	}
