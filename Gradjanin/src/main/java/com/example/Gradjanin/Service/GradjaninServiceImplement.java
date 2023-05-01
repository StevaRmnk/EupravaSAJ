package com.example.Gradjanin.Service;

import com.example.Gradjanin.Model.Gradjanin;
import com.example.Gradjanin.Repository.GradjaninRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradjaninServiceImplement implements GradjaninService{

    @Autowired
    private GradjaninRepository gradjaninRepository;

    @Override
    public List<Gradjanin> nadjiSveGradjane() {
        return gradjaninRepository.findAll();
    }

    @Override
    public Gradjanin nadjiJednogGradjanina(String id) {
        return gradjaninRepository.findById(id).orElseGet(null);
    }
}
