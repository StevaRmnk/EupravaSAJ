package com.example.Policija.Service;

import com.example.Policija.Model.Policajac;

import java.util.List;

public interface PolicajacService {

    public List<Policajac> nadjiSvePolicajce();
    public Policajac nadjiJednogPolicajca(String jmbgPolicajca);
}
