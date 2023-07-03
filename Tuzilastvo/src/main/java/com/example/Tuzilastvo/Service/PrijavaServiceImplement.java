package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.DTO.PrijavaGradjaninaDTO;
import com.example.Tuzilastvo.Model.PrijavaGradjanina;
import com.example.Tuzilastvo.Model.Status;
import com.example.Tuzilastvo.Repository.PrijavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavaServiceImplement implements  PrijavaService{
    @Autowired
    private PrijavaRepository prijavaRepository;

    @Override
    public PrijavaGradjanina napraviPrijavu(PrijavaGradjaninaDTO prijava) {
        PrijavaGradjanina x = new PrijavaGradjanina();
        x.setAnonimna(prijava.getAnonimna());
        x.setDatumPodizanjaPrijave(prijava.getDatumPodizanjaPrijave());
        x.setStatusPrijave(Status.NACEKANJU);
        x.setJmbgOsumnjicenog(prijava.getJmbgOsumnjicenog());
        x.setOpisPrekrsaja(prijava.getOpisPrekrsaja());
        x.setJmbgGradjanina(prijava.getJmbgGradjanina());
        return prijavaRepository.save(x);
    }

    @Override
    public List<PrijavaGradjanina> nadjiSvePrijave() {
        return prijavaRepository.findAll();
    }
}
