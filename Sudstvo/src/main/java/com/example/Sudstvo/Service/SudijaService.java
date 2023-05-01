package com.example.Sudstvo.Service;

import com.example.Sudstvo.Model.Sudija;

import java.util.List;

public interface SudijaService {

    public List<Sudija> nadjiSveSudije();
    public Sudija nadjiJednogSudiju(String brojSudijskeLicence);
}
