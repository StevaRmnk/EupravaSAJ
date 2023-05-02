package com.example.Sudstvo.Service;

import com.example.Sudstvo.Model.Presuda;
import com.example.Sudstvo.Repository.PresudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PresudaServiceImplement implements PresudaService{

    @Autowired
    private PresudaRepository presudaRepository;

    @Override
    public List<Presuda> nadjiSvePresude() {
        return presudaRepository.findAll();
    }

    @Override
    public List<Presuda> nadjiSvePresudeJednogSudije(String brojSudijskeLicence) {
        return presudaRepository.nadjiSvePresudeJednogSudije(brojSudijskeLicence);
    }

    @Override
    public List<Presuda> nadjiSvePresudeJednogGradjanina(String jmbgGradjanina) {
        return null;
    }

    @Override
    public Presuda nadjiJednuPresudu(int idPresude) {
        return presudaRepository.findById(idPresude).orElseGet(null);
    }

    @Override
    public Presuda napraviNovuPresudu(Presuda presuda) {
       return presudaRepository.save(presuda);
    }
}
