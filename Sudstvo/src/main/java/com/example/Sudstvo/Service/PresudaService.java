package com.example.Sudstvo.Service;

import com.example.Sudstvo.Model.Presuda;

import java.util.List;

public interface PresudaService {

    public List<Presuda> nadjiSvePresude();
    public List<Presuda> nadjiSvePresudeJednogSudije(String brojSudijskeLicence);
    public List<Presuda> nadjiSvePresudeJednogGradjanina(String jmbgGradjanina);
    public Presuda nadjiJednuPresudu(int idPresude);
    public void napraviNovuPresudu();
}