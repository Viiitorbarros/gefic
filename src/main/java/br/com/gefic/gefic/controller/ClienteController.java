package br.com.gefic.gefic.controller;


import br.com.gefic.gefic.dtos.ClienteRequestDto;
import br.com.gefic.gefic.dtos.ClienteResponseDto;
import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {


    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteResponseDto save(@RequestBody ClienteRequestDto cliente){
      ClienteResponseDto novoCliente =  clienteService.save(cliente);
      return novoCliente;
    }

    @GetMapping("/{id}")
    public ClienteResponseDto findByid(@PathVariable Long id){
        ClienteResponseDto clienteDto = clienteService.findById(id);

        return clienteDto;
    }

    @GetMapping
    public List<ClienteResponseDto> findByAll(){

        List<ClienteResponseDto> listDtoClientes = clienteService.findByAll();

        return  listDtoClientes;

    }

}
