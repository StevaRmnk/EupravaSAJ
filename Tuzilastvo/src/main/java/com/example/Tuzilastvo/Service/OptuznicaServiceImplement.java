package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.Model.Optuznica;
import com.example.Tuzilastvo.Model.Status;
import com.example.Tuzilastvo.Repository.OptuznicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Integer idZap = optuznica.getIdZapisnika();
        Integer idPrij = optuznica.getIdPrijaveGradjanina();

//        if(idZap == null && idPrij == null){
//            throw new IllegalArgumentException("Id zapisnika i prijave su null!");
//        }

        return optuznicaRepository.save(optuznica);
    }

    @Override
    public Optuznica statusOptuznice(int idOptuznice) {
        Optional<Optuznica> x = optuznicaRepository.findById(idOptuznice);
        Optuznica optuznica = x.get();
        optuznica.setStatusOptuznice(Status.PRIHVACENA);
        Optuznica updatedOptuznica = optuznicaRepository.save(optuznica);
        return updatedOptuznica;
    }
}
