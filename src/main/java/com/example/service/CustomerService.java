package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.CustomerDetails;
import com.example.repository.CustomerDetailsRepository;
 
@Service
@Transactional
public class CustomerService {
 
    @Autowired
    private CustomerDetailsRepository repo;
     
    public List<CustomerDetails> listAll() {
        return repo.findAll();
    }
     
    public void save(CustomerDetails customerDetails) {
        repo.save(customerDetails);
    }
     
    public CustomerDetails get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}