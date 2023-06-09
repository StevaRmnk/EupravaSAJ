package com.example.Policija.Repository;

import com.example.Policija.Model.Zapisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZapisnikRepository extends JpaRepository<Zapisnik,Integer> {


    List<Zapisnik> findZapisnikByBrojZnackeOrderByDatumPravljenjaZapisnikaDesc(String jmbgPolicajca);

    List<Zapisnik> findZapisnikByJmbgOsumnjicenog(String jmbgGradjanina);
}
