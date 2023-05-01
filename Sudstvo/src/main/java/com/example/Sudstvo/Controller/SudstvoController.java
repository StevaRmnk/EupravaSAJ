package com.example.Sudstvo.Controller;

import com.example.Sudstvo.Model.Presuda;
import com.example.Sudstvo.Model.Sudija;
import com.example.Sudstvo.Service.PresudaService;
import com.example.Sudstvo.Service.SudijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sudstvo")
public class SudstvoController {

    @Autowired
    private SudijaService sudijaService;

    @Autowired
    private PresudaService presudaService;

    @GetMapping(value = "/sudije/")
    public ResponseEntity<List<Sudija>> nadjiSveSudije(){
        return new ResponseEntity<>(sudijaService.nadjiSveSudije(), HttpStatus.OK);
    }

    @GetMapping(value = "/sudije/{id}")
    public ResponseEntity<Sudija> nadjiJednogSudiju(@PathVariable("id")String brojSudijskeLicence){
        return new ResponseEntity<>(sudijaService.nadjiJednogSudiju(brojSudijskeLicence),HttpStatus.OK);
    }

    @GetMapping(value = "/presude/")
    public ResponseEntity<List<Presuda>> nadjiSvePresude(){
        return new ResponseEntity<>(presudaService.nadjiSvePresude(),HttpStatus.OK);
    }

    @GetMapping(value = "/presude/{id}")
    public ResponseEntity<Presuda> nadjiJednuPresudu(@PathVariable("id") int idPresude){
        return new ResponseEntity<>(presudaService.nadjiJednuPresudu(idPresude),HttpStatus.OK);
    }

    @GetMapping(value = "presude/sudija/{id}")
    public ResponseEntity<List<Presuda>> nadjiSvePresudeJednogSudije(@PathVariable("id") String brojSudijskeLicence){
        return new ResponseEntity<>(presudaService.nadjiSvePresudeJednogSudije(brojSudijskeLicence),HttpStatus.OK);
    }


}
