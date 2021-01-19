package com.example.demo.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Customer")

public class Customer {
	@Id
    @GeneratedValue
	private int custid;
	private String customerName;
	private String customerEmail;
	private Long customerMobile;

}
