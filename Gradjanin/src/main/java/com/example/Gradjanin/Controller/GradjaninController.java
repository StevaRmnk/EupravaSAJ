package com.example.Gradjanin.Controller;

import com.example.Gradjanin.Model.Gradjanin;
import com.example.Gradjanin.Service.GradjaninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gradjani")
public class GradjaninController {

    @Autowired
    private GradjaninService gradjaninService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Gradjanin>> SviGradjani(){

        return new ResponseEntity<>(gradjaninService.findAll(), HttpStatus.OK);

    }

//    @GetMapping("/login")
//    public Map<String, Object> currentUser(OAuth2AuthenticationToken authentication){
//
//        return authentication.getPrincipal().getAttributes();
//    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }
}
