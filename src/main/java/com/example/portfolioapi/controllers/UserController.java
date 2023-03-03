package com.example.portfolioapi.controllers;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.portfolioapi.models.PersonaModel;
import com.example.portfolioapi.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "https://portfolio-mcg.web.app")
@RestController
@RequestMapping("/api/login")
public class UserController {
    
    @Autowired
    PersonaService personaService;

    private String getJWTToken(String username){
        String secretKey = "GU4Y4B4";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("ap17mcg")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hora de duración
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes())
                .compact();

        return "Bearer " + token;
    }

    @PostMapping
    public ResponseEntity<PersonaModel> login(@Validated @RequestBody PersonaModel user) {

        PersonaModel persona = personaService.getByUsername(user.getUsername());
        if (persona.getPassword().equals(user.getPassword())) {
            String token = getJWTToken(user.getUsername());
            persona.setToken(token);
            persona.setPassword(null);
            return ResponseEntity.ok().body(persona);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
