package com.example.Sudstvo.Controller;

import com.example.Sudstvo.DTO.LoginDTO;
import com.example.Sudstvo.DTO.TokenDTO;
import com.example.Sudstvo.Model.Optuznica;
import com.example.Sudstvo.Model.Presuda;
import com.example.Sudstvo.Model.Sudija;
import com.example.Sudstvo.Model.Sudjenje;
import com.example.Sudstvo.Service.PresudaService;
import com.example.Sudstvo.Service.SudijaService;
import com.example.Sudstvo.Service.SudjenjeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sudstvo")
@CrossOrigin(origins = "http://localhost:4203")
public class SudstvoController {

    @Autowired
    private SudijaService sudijaService;

    @Autowired
    private PresudaService presudaService;

    @Autowired
    private SudjenjeService sudjenjeService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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

    @GetMapping(value = "/presude/sudija/{id}")
    public ResponseEntity<List<Presuda>> nadjiSvePresudeJednogSudije(@PathVariable("id") String brojSudijskeLicence){
        return new ResponseEntity<>(presudaService.nadjiSvePresudeJednogSudije(brojSudijskeLicence),HttpStatus.OK);
    }

    @PostMapping("/presude/")
    public ResponseEntity<Presuda> napraviNovuPresudu(@RequestBody Presuda presuda){
        return new ResponseEntity<>(presudaService.napraviNovuPresudu(presuda),HttpStatus.OK);
    }

    @PostMapping("/sudjenje/")
    public ResponseEntity<Sudjenje> napraviSudjenje(@RequestBody Sudjenje sudjenje){
        Sudjenje x =sudjenjeService.napraviSudjenje(sudjenje);
        String optuznicaStatusUrl = "http://tuzilastvo:8082/tuzilastvo/optuznica/status/" + x.getIdOptuznice();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(optuznicaStatusUrl, null);

        return new ResponseEntity<>(x,HttpStatus.OK);
    }

    @GetMapping(value = "/sudjenje/{id}")
    public ResponseEntity<List<Sudjenje>> nadjiSudjenja(@PathVariable("id") String brojLicence){
        return new ResponseEntity<>(sudjenjeService.nadjiSudjenja(brojLicence),HttpStatus.OK);
    }

    @GetMapping(value = "/sudjenje/osumnjiceni/{email}")
    public ResponseEntity<List<Sudjenje>> nadjiSudjenjaOsumnjicenog(@PathVariable("email") String jmbgOsumnnjicenog){
        return new ResponseEntity<>(sudjenjeService.nadjiSudjenjaOsumnjicenog(jmbgOsumnnjicenog),HttpStatus.OK);
    }

    @GetMapping(value = "/optuznice")
    public ResponseEntity<List<Optuznica>> nadjiOptuznice( @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("your-secret-key")
                    .parseClaimsJws(token)
                    .getBody();

            String subject = claims.getSubject();
            if(sudijaService.nadjiJednogSudiju(subject)== null){
                return ResponseEntity.badRequest().build();
            }

        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


        String url = "http://tuzilastvo:8082/tuzilastvo/optuznice/";
        RestTemplate restTemplate = new RestTemplate();

// Send the GET request and retrieve the response directly as an object
        List<Optuznica> optuznice = restTemplate.getForObject(url, List.class);

        return new ResponseEntity<>(optuznice, HttpStatus.OK);
    }

    @PostMapping(value = "/login",consumes = "application/json")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO){

        String brojLicence = loginDTO.getBrojLicence();
        String lozinka = loginDTO.getLozinka();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Sudija sudija = sudijaService.nadjiJednogSudiju(brojLicence);


        if (sudija != null && passwordEncoder.matches(lozinka, sudija.getLozinka())){
            String jwtToken = generateToken(sudija.getBrojSudijskeLicence(), sudija.getIme(), sudija.getPrezime());
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



}
