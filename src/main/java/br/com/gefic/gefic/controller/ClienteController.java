package br.com.gefic.gefic.controller;


import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GetMapping("/cliente")
public class ClienteController {


    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

}
