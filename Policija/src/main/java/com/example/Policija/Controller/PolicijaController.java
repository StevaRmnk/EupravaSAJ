package com.example.Policija.Controller;

import com.example.Policija.Model.Policajac;
import com.example.Policija.Model.Zapisnik;
import com.example.Policija.Service.PolicajacService;
import com.example.Policija.Service.ZapisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("policija")
public class PolicijaController {

    @Autowired
    private PolicajacService policajacService;

    @Autowired
    private ZapisnikService zapisnikService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Policajac>> nadjiSvePolicajce(){
        return new ResponseEntity<>(policajacService.nadjiSvePolicajce(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policajac> nadjiJednogPolicajca(@PathVariable("id")String jmbgPolicajca){
        return new ResponseEntity<>(policajacService.nadjiJednogPolicajca(jmbgPolicajca),HttpStatus.OK);
    }

    @PostMapping(value = "/zapisnici/",consumes = "application/json")
    public ResponseEntity<Zapisnik> napraviZapisnik(@RequestBody Zapisnik zapisnik){
        return new ResponseEntity<>(zapisnikService.napraviZapisnik(zapisnik),HttpStatus.CREATED);
    }


}
