package br.com.gefic.gefic.controller;

import br.com.gefic.gefic.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UserDetailsService userDetailsService;

    public Usuario save (Usuario usuario){


    }




}
