package com.example.Policija.Service;

import com.example.Policija.Model.Dokaz;
import com.example.Policija.Model.Zapisnik;

import java.util.List;

public interface DokazService {

    public List<Dokaz> nadjiSveDokaze();
    public Dokaz nadjiJedanDokaz(int idDokaza);
    public List<Dokaz> nadjiListuDokazaZaZapisnik(int idZapisnika);
    public void dodajDokaz(Dokaz dokaz);
}
