package com.example.Tuzilastvo.Repository;

import com.example.Tuzilastvo.Model.Optuznica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface OptuznicaRepository extends JpaRepository<Optuznica,Integer> {

    @Transactional
    @Query(value = "select * from optuznice o  where o.broj_licence_tuzioca = ?1",
            nativeQuery = true)
    List<Optuznica> nadjiSveOptuzniceJednogTuzioca(String jmbgTuzioca);
}
