package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.dto.TokenDto;
import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    //busca o parâmetro que foi colocado na application.properties
    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public TokenDto gerar(Authentication pAuthenticate) {

        LoginEntity usuario = (LoginEntity) pAuthenticate.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return new TokenDto(Jwts.builder()
                .setIssuer("API Fórum Alura")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact(), "Bearer");
    }

    public boolean isValid(String pToken) {

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(pToken);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public long getIdUsuario(String pToken) {

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(pToken).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
