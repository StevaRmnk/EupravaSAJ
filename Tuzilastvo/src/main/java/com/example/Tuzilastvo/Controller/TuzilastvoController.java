package com.example.Tuzilastvo.Controller;


import com.example.Tuzilastvo.Model.Optuznica;
import com.example.Tuzilastvo.Model.Tuzilac;
import com.example.Tuzilastvo.Service.OptuznicaService;
import com.example.Tuzilastvo.Service.TuzilacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tuzilastvo")
public class TuzilastvoController {

    @Autowired
    private TuzilacService tuzilacService;

    @Autowired
    private OptuznicaService optuznicaService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Tuzilac>> nadjiSveTuzioce(){
        return new ResponseEntity<>(tuzilacService.nadjiSveTuzioce(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tuzilac> nadjiJednogTuzioca(@PathVariable("id") String jmbgTuzioca){
        return new ResponseEntity<>(tuzilacService.nadjiJednogTuzioca(jmbgTuzioca),HttpStatus.OK);
    }

    @GetMapping(value = "/optuznice/")
    public ResponseEntity<List<Optuznica>> nadjiSveOptuznice(){
        return new ResponseEntity<>(optuznicaService.nadjiSveOptuznice(),HttpStatus.OK);
    }

    @GetMapping(value = "/optuznice/{id}")
    public ResponseEntity<Optuznica> nadjiJednuOptuznicu(@PathVariable("id") int idOptuznice){
        return new ResponseEntity<>(optuznicaService.nadjiJednuOptuznicu(idOptuznice),HttpStatus.OK);
    }

    @GetMapping(value = "/optuznice/tuzilac/{id}")
    public ResponseEntity<List<Optuznica>> nadjiSveOptuzniceJednogTuzioca(@PathVariable("id")String jmbgTuzioca){
        return new ResponseEntity<>(optuznicaService.nadjiSveOptuzniceJednogTuzioca(jmbgTuzioca),HttpStatus.OK);
    }

    @PostMapping(value = "/optuznice/")
    public ResponseEntity<Optuznica> napraviOptuznicu(@RequestBody Optuznica optuznica){
        return new ResponseEntity<>(optuznicaService.napraviOptuznicu(optuznica),HttpStatus.CREATED);
    }

}
