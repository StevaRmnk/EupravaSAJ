package com.example.Sudstvo.Service;

import com.example.Sudstvo.Model.Sudjenje;
import com.example.Sudstvo.Repository.SudjenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SudjenjeServiceImplement implements SudjenjeService {
    @Autowired
    private SudjenjeRepository sudjenjeRepository;

    @Override
    public Sudjenje napraviSudjenje(Sudjenje sudjenje) {
        return sudjenjeRepository.save(sudjenje);
    }

    @Override
    public List<Sudjenje> nadjiSudjenja(String brojLicence) {
        return sudjenjeRepository.findSudjenjeByBrojSudijskeLicence(brojLicence);
    }

    @Override
    public List<Sudjenje> nadjiSudjenjaOsumnjicenog(String jmbgOsumnjicenog) {
        return sudjenjeRepository.findSudjenjeByJmbgOptuzenog(jmbgOsumnjicenog);
    }


}
