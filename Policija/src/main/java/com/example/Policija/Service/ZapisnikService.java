package com.example.Policija.Service;

import com.example.Policija.Model.Zapisnik;

import java.util.List;

public interface ZapisnikService {

    public List<Zapisnik> nadjiSveZapisnike();
    public Zapisnik nadjiJedanZapisnik(int idZapisnika);
    public Zapisnik napraviZapisnik(Zapisnik zapisnik);
    public List<Zapisnik> nadjiSveZapisnikePolicajca(String jmbgPolicajca);
    public List<Zapisnik> nadjiSveZapisnikeGradjanina(String jmbgGradjanina);
}
