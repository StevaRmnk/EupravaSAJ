package com.example.Tuzilastvo.Repository;

import com.example.Tuzilastvo.Model.PrijavaGradjanina;
import com.example.Tuzilastvo.Model.Tuzilac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrijavaRepository extends JpaRepository<PrijavaGradjanina,Integer> {
}
