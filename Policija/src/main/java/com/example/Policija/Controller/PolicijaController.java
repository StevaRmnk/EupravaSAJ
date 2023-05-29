package com.example.Policija.Controller;

import com.example.Policija.DTO.LoginDTO;
import com.example.Policija.DTO.TokenDTO;
import com.example.Policija.DTO.ZapisnikDTO;
import com.example.Policija.Model.Dokaz;
import com.example.Policija.Model.Policajac;
import com.example.Policija.Model.TipDokaza;
import com.example.Policija.Model.Zapisnik;
import com.example.Policija.Service.DokazService;
import com.example.Policija.Service.PolicajacService;
import com.example.Policija.Service.ZapisnikService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("policija")
@CrossOrigin(origins = "http://localhost:4201")
public class PolicijaController {

    @Autowired
    private PolicajacService policajacService;

    @Autowired
    private ZapisnikService zapisnikService;

    @Autowired
    private DokazService dokazService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Policajac>> nadjiSvePolicajce(){
        return new ResponseEntity<>(policajacService.nadjiSvePolicajce(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policajac> nadjiJednogPolicajca(@PathVariable("id")String jmbgPolicajca){
        return new ResponseEntity<>(policajacService.nadjiJednogPolicajca(jmbgPolicajca),HttpStatus.OK);
    }

    @GetMapping("/zapisnici/{id}")
    public ResponseEntity<List<Zapisnik>> nadjiZapisnikePolicajca(@PathVariable("id")String jmbgPolicajca){
        return new ResponseEntity<>(zapisnikService.nadjiSveZapisnikePolicajca(jmbgPolicajca),HttpStatus.OK);
    }

    @PostMapping(value = "/zapisnici/",consumes = "application/json")
    public ResponseEntity<ZapisnikDTO> napraviZapisnik(@RequestBody @Valid ZapisnikDTO zapisnik, BindingResult bindingResult, @RequestHeader("Authorization") String authorizationHeader){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        String token = authorizationHeader.substring(7);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("your-secret-key")
                    .parseClaimsJws(token)
                    .getBody();

            String subject = claims.getSubject();
            if(policajacService.nadjiJednogPolicajca(subject)== null){
                return ResponseEntity.badRequest().build();
            }

        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if(zapisnik.getDatumZavodjenjaDokaza().isAfter(LocalDate.now()) && !zapisnik.getDatumZavodjenjaDokaza().isEqual(LocalDate.now())){
            return ResponseEntity.badRequest().build();
        }

        Zapisnik x = new Zapisnik();
        x.setBrojZnacke(zapisnik.getBrojZnacke());
        x.setJmbgOsumnjicenog(zapisnik.getJmbgOsumnjicenog());
        if(zapisnik.getDatumPravljenjaZapisnika().isBefore(LocalDateTime.now()) || zapisnik.getDatumPravljenjaZapisnika().equals(LocalDateTime.now())){
            x.setDatumPravljenjaZapisnika(zapisnik.getDatumPravljenjaZapisnika());
        }else
        {
            return ResponseEntity.badRequest().build();
        }
        x.setOpisPrekrsaja(zapisnik.getOpisPrekrsaja());
        Zapisnik noviZapisnik = zapisnikService.napraviZapisnik(x);

        //Upisi dokaz ukoliko je zapisnik validan
        if (noviZapisnik != null) {
            Dokaz noviDokaz = new Dokaz();
            noviDokaz.setIdZapisnika(noviZapisnik.getIdZapisnika());
            noviDokaz.setTipDokaza(TipDokaza.valueOf(zapisnik.getTipDokaza()));
            noviDokaz.setDatumZavodjenjaDokaza(zapisnik.getDatumZavodjenjaDokaza());
            dokazService.dodajDokaz(noviDokaz);
        }


        return new ResponseEntity<>(zapisnik,HttpStatus.CREATED);
    }

    @PostMapping(value = "/login",consumes = "application/json")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO){

        String brojZnacke = loginDTO.getBrojZnacke();
        String lozinka = loginDTO.getLozinka();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Policajac policajac = policajacService.nadjiJednogPolicajca(brojZnacke);


        if (policajac != null && passwordEncoder.matches(lozinka, policajac.getLozinka())){
            String jwtToken = generateToken(policajac.getBrojZnacke(), policajac.getIme(), policajac.getPrezime());
            TokenDTO tokenDTO = new TokenDTO(jwtToken);
            return ResponseEntity.ok(tokenDTO);
        }else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

    private String generateToken(String brojZnacke, String ime, String prezime) {
        // Generate JWT token with the user ID as the subject
        String secretKey = "your-secret-key";
        long expirationTime = 1000 * 60 * 60 * 24; // 24 hours
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(brojZnacke)
                .claim("ime", ime)
                .claim("prezime", prezime)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }



}
