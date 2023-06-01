package com.example.Tuzilastvo.Controller;


import com.example.Tuzilastvo.DTO.LoginDTO;
import com.example.Tuzilastvo.DTO.TokenDTO;
import com.example.Tuzilastvo.Model.Optuznica;
import com.example.Tuzilastvo.Model.Tuzilac;
import com.example.Tuzilastvo.Model.Zapisnik;
import com.example.Tuzilastvo.Service.OptuznicaService;
import com.example.Tuzilastvo.Service.TuzilacService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("tuzilastvo")
@CrossOrigin(origins = "http://localhost:4202")
public class TuzilastvoController {

    @Autowired
    private TuzilacService tuzilacService;

    @Autowired
    private OptuznicaService optuznicaService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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

        System.out.println(optuznica.getIdOptuznice());

        return new ResponseEntity<>(optuznicaService.napraviOptuznicu(optuznica),HttpStatus.CREATED);
    }

    @PostMapping(value = "/login",consumes = "application/json")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO){

        String brojLicence = loginDTO.getBrojLicence();
        String lozinka = loginDTO.getLozinka();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(brojLicence);
        System.out.println(lozinka);
        Tuzilac tuzilac = tuzilacService.nadjiJednogTuzioca(brojLicence);


        if (tuzilac != null && passwordEncoder.matches(lozinka, tuzilac.getLozinka())){
            String jwtToken = generateToken(tuzilac.getBrojLicenceTuzioca(), tuzilac.getIme(), tuzilac.getPrezime());
            TokenDTO tokenDTO = new TokenDTO(jwtToken);
            return ResponseEntity.ok(tokenDTO);
        }else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

    private String generateToken(String brojLicence, String ime, String prezime) {
        // Generate JWT token with the user ID as the subject
        String secretKey = "your-secret-key";
        long expirationTime = 1000 * 60 * 60 * 24; // 24 hours
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(brojLicence)
                .claim("ime", ime)
                .claim("prezime", prezime)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @GetMapping(value = "/zapisnici/")
    public ResponseEntity<List<Zapisnik>> nadjiSveZapisnike( @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("your-secret-key")
                    .parseClaimsJws(token)
                    .getBody();

            String subject = claims.getSubject();
            if(tuzilacService.nadjiJednogTuzioca(subject)== null){
                return ResponseEntity.badRequest().build();
            }

        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


        String url = "http://policija:8080/policija/zapisnici";
        RestTemplate restTemplate = new RestTemplate();

// Send the GET request and retrieve the response directly as an object
        List<Zapisnik> zapisnici = restTemplate.getForObject(url, List.class);

        return new ResponseEntity<>(zapisnici, HttpStatus.OK);
    }

}
