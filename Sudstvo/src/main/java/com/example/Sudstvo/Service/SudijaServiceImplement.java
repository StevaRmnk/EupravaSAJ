package com.example.Sudstvo.Service;

import com.example.Sudstvo.Model.Sudija;
import com.example.Sudstvo.Repository.SudijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SudijaServiceImplement implements SudijaService{

    @Autowired
    private SudijaRepository sudijaRepository;

    @Override
    public List<Sudija> nadjiSveSudije() {
        return sudijaRepository.findAll();
    }

    @Override
    public Sudija nadjiJednogSudiju(String brojSudijskeLicence) {
        return sudijaRepository.findById(brojSudijskeLicence).orElseGet(null);
    }
}
