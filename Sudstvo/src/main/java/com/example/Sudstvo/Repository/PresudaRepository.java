package com.example.Sudstvo.Repository;

import com.example.Sudstvo.Model.Presuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PresudaRepository extends JpaRepository<Presuda,Integer> {

    @Transactional
    @Query(value = "select * from presude p  where o.broj_sudijske_licence = ?1",
            nativeQuery = true)
    List<Presuda> nadjiSvePresudeJednogSudije(String brojSudijskeLicence);

}
