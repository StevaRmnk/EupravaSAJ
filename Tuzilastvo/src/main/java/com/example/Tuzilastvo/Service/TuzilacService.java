package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.Model.Tuzilac;

import java.util.List;

public interface TuzilacService {

    public List<Tuzilac> nadjiSveTuzioce();

    public Tuzilac nadjiJednogTuzioca(String jmbgTuzioca);
}
