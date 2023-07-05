package com.example.Sudstvo.Service;

import com.example.Sudstvo.Model.Presuda;
import com.example.Sudstvo.Model.Sudija;
import com.example.Sudstvo.Model.Sudjenje;

import java.util.List;

public interface SudjenjeService {
    public Sudjenje napraviSudjenje(Sudjenje sudjenje);
    public List<Sudjenje> nadjiSudjenja(String brojLicence);

    public List<Sudjenje> nadjiSudjenjaOsumnjicenog(String jmbgOsumnjicenog);




}
