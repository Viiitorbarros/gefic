package br.com.gefic.gefic.controller;


import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {


    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente){
      Cliente novoCliente =  clienteService.save(cliente);
      return novoCliente;
    }

    @GetMapping("/{id}")
    public Cliente findByid(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        return cliente;
    }

}
