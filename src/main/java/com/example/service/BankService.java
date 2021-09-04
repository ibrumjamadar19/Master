package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.bean.FevoriteBankDetails;
import com.example.repository.FevoriteBankDetailsRepository;
 
@Service
@Transactional
public class BankService {
 
    @Autowired
    private FevoriteBankDetailsRepository repo;
     
    public List<FevoriteBankDetails> listAll() {
        return repo.findAll();
    }
     
    public void save(FevoriteBankDetails fevoriteBankDetails) {
        repo.save(fevoriteBankDetails);
    }
     
    public FevoriteBankDetails get(Integer id) {
        return repo.findById(id).get();
    }
    
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}