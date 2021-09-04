package com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.bean.BankDetails;
import com.example.bean.Customer;
import com.example.bean.CustomerDetails;
import com.example.bean.FevoriteBankDetails;
import com.example.service.BankService;
import com.example.service.CustomerService;

@RestController
@RequestMapping("PayeeDetails")
class PayeeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    private CustomerService customerService;
	
	@Autowired
    private BankService bankService;
	
	@PostMapping("/login")
	public ResponseEntity<CustomerDetails> add(@RequestBody Customer customer) {
		try {
			CustomerDetails customerDetails = customerService.get(customer.customerId);
	        if (customerDetails.getPassword().equalsIgnoreCase(customer.password)) {
	        	return new ResponseEntity<CustomerDetails>(customerDetails, HttpStatus.OK);
	        } else {
	        	 return new ResponseEntity<CustomerDetails>(HttpStatus.NOT_FOUND);
	        }
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CustomerDetails>(HttpStatus.NOT_FOUND);
	    }   
	}
	
	@PostMapping("/addFevoritePayee")
	public void add(@RequestBody FevoriteBankDetails fevoriteBankDetails) {
	    bankService.save(fevoriteBankDetails);
	}
	
	@PutMapping("/updateFevoritePayee/{id}")
	public ResponseEntity<?> update(@RequestBody FevoriteBankDetails fevoriteBankDetails, @PathVariable Integer id) {
	    try {
	    	FevoriteBankDetails existBankDetails = bankService.get(id);
	    	bankService.save(existBankDetails);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/deleteFevoritePayee/{id}")
	public void delete(@PathVariable Integer id) {
		bankService.delete(id);
	}
	
	@GetMapping(value = "/bankdetails/{code}")
	public BankDetails getBankName(@PathVariable(value="code") int code) {
		return restTemplate.getForObject(
				"https://localhost:8080/BankDetails/bankdetails/{code}", BankDetails.class);
	}
	
	@GetMapping(value = "getFevoriteBankDetails", params = { "page", "size" })
	public List<FevoriteBankDetails> findPaginated(@RequestParam("page") int page, 
	  @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
	  HttpServletResponse response) {
	    return bankService.listAll();
	}
}
