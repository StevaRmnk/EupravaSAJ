package com.example.Gradjanin.Controller;

import com.example.Gradjanin.Model.Gradjanin;
import com.example.Gradjanin.Repository.GradjaninRepository;
import com.example.Gradjanin.Service.GradjaninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.nimbusds.jwt.JWTClaimNames.EXPIRATION_TIME;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    @Autowired
    private GradjaninRepository gradjaninRepository;

    @GetMapping
    public ResponseEntity<Void> currentUser(HttpServletRequest request, OAuth2AuthenticationToken authentication){
        String referer = request.getHeader("Referer");
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        String accessToken = client.getAccessToken().getTokenValue();
        String jwtToken = generateToken(accessToken,authentication.getPrincipal().getAttributes().get("email").toString(),authentication.getPrincipal().getAttributes().get("picture").toString(),authentication.getPrincipal().getAttributes().get("name").toString());
        String redirectUrl = referer + "?at=" + jwtToken;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwtToken);
        headers.setLocation(URI.create(redirectUrl));

        //Upisi gradjanina ukoliko ne postoji u bazi
        String email = authentication.getPrincipal().getAttributes().get("email").toString();
        Gradjanin gradjanin = gradjaninRepository.findByEmail(email);
        if (gradjanin == null) {
            Gradjanin newGradjanin = new Gradjanin();
            newGradjanin.setEmail(email);
            newGradjanin.setSlika(authentication.getPrincipal().getAttributes().get("picture").toString());
            newGradjanin.setIme(authentication.getPrincipal().getAttributes().get("given_name").toString());
            newGradjanin.setPrezime(authentication.getPrincipal().getAttributes().get("family_name").toString());
            gradjaninRepository.insert(newGradjanin);
        }

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    public static String generateToken(String accessToken, String email, String picture, String name) {
         String SECRET = "my-secret-key";
         long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
         Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(accessToken)
                .claim("email", email)
                .claim("picture", picture)
                .claim("name", name)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
