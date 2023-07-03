package com.example.Tuzilastvo.Service;

import com.example.Tuzilastvo.DTO.PrijavaGradjaninaDTO;
import com.example.Tuzilastvo.Model.Optuznica;
import com.example.Tuzilastvo.Model.PrijavaGradjanina;

import java.util.List;

public interface PrijavaService {
    public PrijavaGradjanina napraviPrijavu(PrijavaGradjaninaDTO prijava);
    public List<PrijavaGradjanina> nadjiSvePrijave();
}
