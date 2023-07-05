package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.Model.Optuznica;

import java.util.List;

public interface OptuznicaService {

    public List<Optuznica> nadjiSveOptuznice();

    public List<Optuznica> nadjiSveOptuzniceJednogTuzioca(String jmbgTuzioca);

    public List<Optuznica> nadjiSveOptuzniceJednogGradjanina(String jmbgGradjanina);

    public Optuznica nadjiJednuOptuznicu(int idOptuznice);

    public Optuznica napraviOptuznicu(Optuznica optuznica);

    public Optuznica statusOptuznice(int idOptuznice);
}
