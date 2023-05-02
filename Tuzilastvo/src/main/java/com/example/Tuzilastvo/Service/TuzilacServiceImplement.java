package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.Model.Tuzilac;
import com.example.Tuzilastvo.Repository.TuzilacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuzilacServiceImplement implements TuzilacService{

    @Autowired
    private TuzilacRepository tuzilacRepository;

    @Override
    public List<Tuzilac> nadjiSveTuzioce() {
        return tuzilacRepository.findAll();
    }

    @Override
    public Tuzilac nadjiJednogTuzioca(String jmbgTuzioca) {
        return tuzilacRepository.findById(jmbgTuzioca).orElseGet(null);
    }
}
