package com.example.Policija.Service;

import com.example.Policija.Model.Policajac;
import com.example.Policija.Repository.PolicajacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicajacServiceImplement implements PolicajacService{

    @Autowired
    private PolicajacRepository policajacRepository;

    @Override
    public List<Policajac> nadjiSvePolicajce() {
        return policajacRepository.findAll();
    }

    @Override
    public Policajac nadjiJednogPolicajca(String jmbgPolicajca) {
        return policajacRepository.findById(jmbgPolicajca).orElseGet(null);
    }
}
