package com.example.Sudstvo.Repository;

import com.example.Sudstvo.Model.Sudija;
import com.example.Sudstvo.Model.Sudjenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SudjenjeRepository  extends JpaRepository<Sudjenje,Integer> {
    List<Sudjenje> findSudjenjeByBrojSudijskeLicence(String brojSudijskeLicence);

    List<Sudjenje> findSudjenjeByJmbgOptuzenog(String jmbgOptuzenog);
}
