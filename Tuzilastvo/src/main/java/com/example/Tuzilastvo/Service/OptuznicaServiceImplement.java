package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.Model.Optuznica;
import com.example.Tuzilastvo.Repository.OptuznicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptuznicaServiceImplement implements OptuznicaService{

    @Autowired
    private OptuznicaRepository optuznicaRepository;


    @Override
    public List<Optuznica> nadjiSveOptuznice() {
        return optuznicaRepository.findAll();
    }

    @Override
    public List<Optuznica> nadjiSveOptuzniceJednogTuzioca(String jmbgTuzioca) {
        return optuznicaRepository.nadjiSveOptuzniceJednogTuzioca(jmbgTuzioca);
    }

    @Override
    public List<Optuznica> nadjiSveOptuzniceJednogGradjanina(String jmbgGradjanina) {
        return null;
    }

    @Override
    public Optuznica nadjiJednuOptuznicu(int idOptuznice) {
        return optuznicaRepository.findById(idOptuznice).orElseGet(null);
    }

    @Override
    public Optuznica napraviOptuznicu(Optuznica optuznica) {
        return optuznicaRepository.save(optuznica);
    }
}
