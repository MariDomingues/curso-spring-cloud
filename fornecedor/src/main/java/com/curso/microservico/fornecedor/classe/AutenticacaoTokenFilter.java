package com.curso.microservico.fornecedor.classe;

import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import com.curso.microservico.fornecedor.service.TokenService;
import com.curso.microservico.fornecedor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//intercepta a requisição e executar a lógica antes que caia no controller
public class AutenticacaoTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginService loginService;

    public AutenticacaoTokenFilter(TokenService tokenService, LoginService loginService) {
        this.tokenService = tokenService;
        this.loginService = loginService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest pRequest,
                                    HttpServletResponse pResponse,
                                    FilterChain pFilterChain) throws ServletException, IOException {

        String token = recuperarToken(pRequest);
        boolean tokenValido = tokenService.isValid(token);

        if (tokenValido) {

            autenticarCliente(token);
        }

        pFilterChain.doFilter(pRequest, pResponse);
    }

    private void autenticarCliente(String pToken) {

        long idUsuario = tokenService.getIdUsuario(pToken);
        LoginEntity usuario = loginService.getUsuario(idUsuario);

        UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

        //autentica o usuário
        SecurityContextHolder.getContext().setAuthentication(autenticacao);
    }

    private String recuperarToken(HttpServletRequest pRequest) {

        String token = pRequest.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
