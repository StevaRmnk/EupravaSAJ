package com.example.Policija.Service;

import com.example.Policija.Model.Dokaz;
import com.example.Policija.Model.Zapisnik;
import com.example.Policija.Repository.DokazRepository;
import com.example.Policija.Repository.ZapisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DokazServiceImplement implements DokazService{

    @Autowired
    private DokazRepository dokazRepository;

    @Autowired
    private ZapisnikRepository zapisnikRepository;

    @Override
    public List<Dokaz> nadjiSveDokaze() {
        return dokazRepository.findAll();
    }

    @Override
    public Dokaz nadjiJedanDokaz(int idDokaza) {
        return dokazRepository.findById(idDokaza).orElseGet(null);
    }

    @Override
    public List<Dokaz> nadjiListuDokazaZaZapisnik(int idZapisnika) {
        return dokazRepository.findDokazsByZapisniksId(idZapisnika);
    }

    @Override
    public List<Zapisnik> nadjiListuZapisnikaZaDokaz(int idDokaza) {
        return zapisnikRepository.findZapisniksByDokazsId(idDokaza);
    }

    @Override
    public void dodajDokaz(Dokaz dokaz) {
        dokazRepository.save(dokaz);
    }
}
