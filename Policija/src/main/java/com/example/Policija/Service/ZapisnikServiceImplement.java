package com.example.Policija.Service;

import com.example.Policija.Model.Zapisnik;
import com.example.Policija.Repository.ZapisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZapisnikServiceImplement implements ZapisnikService{

    @Autowired
    private ZapisnikRepository zapisnikRepository;

    @Override
    public List<Zapisnik> nadjiSveZapisnike() {
        return zapisnikRepository.findAll();
    }

    @Override
    public Zapisnik nadjiJedanZapisnik(int idZapisnika) {
        return zapisnikRepository.findById(idZapisnika).orElseGet(null);
    }

    @Override
    public Zapisnik napraviZapisnik(Zapisnik zapisnik) {
        return zapisnikRepository.save(zapisnik);
    }

    @Override
    public List<Zapisnik> nadjiSveZapisnikePolicajca(String jmbgPolicajca) {
        return zapisnikRepository.findZapisniksByPolicajacsId(jmbgPolicajca);
    }

    @Override
    public List<Zapisnik> nadjiSveZapisnikeGradjanina(String jmbgGradjanina) {
        return zapisnikRepository.findZapisniksByGradjaninsId(jmbgGradjanina);
    }
}
