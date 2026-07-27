package br.com.gefic.gefic.controller;

import br.com.gefic.gefic.dtos.UsuarioRequestDto;
import br.com.gefic.gefic.dtos.UsuarioResponseDto;
import br.com.gefic.gefic.model.Usuario;
import br.com.gefic.gefic.service.UserDatailsService;
import br.com.gefic.gefic.service.UsuarioService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UserDetailsService userDetailsService;
    private UsuarioService usuarioService;

    public UsuarioController(UserDatailsService userDetailsService, UsuarioService usuarioService){

        this.userDetailsService = userDetailsService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponseDto save (@RequestBody UsuarioRequestDto usuarioRequestDto){

        return usuarioService.save(usuarioRequestDto);

    }

    @GetMapping("/{email}")
    public UsuarioResponseDto findbyEmail(@PathVariable String email){
        return usuarioService.findByEmail(email);

    }




}
