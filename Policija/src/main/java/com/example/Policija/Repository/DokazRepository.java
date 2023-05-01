package com.example.Policija.Repository;

import com.example.Policija.Model.Dokaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DokazRepository extends JpaRepository<Dokaz,Integer> {

    List<Dokaz> findDokazsByZapisniksId(int idZapisnika);
}
