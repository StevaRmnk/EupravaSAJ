package com.example.Gradjanin.Controller;

import com.example.Gradjanin.Model.Gradjanin;
import com.example.Gradjanin.Service.GradjaninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gradjani")
public class GradjaninController {

    @Autowired
    private GradjaninService gradjaninService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Gradjanin>> SviGradjani(){

        return new ResponseEntity<>(gradjaninService.findAll(), HttpStatus.OK);

    }

}
