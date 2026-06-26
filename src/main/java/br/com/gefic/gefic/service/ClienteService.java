package br.com.gefic.gefic.service;

import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.repository.ClienteRepository;
import jakarta.el.ELException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    public Cliente findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não Encontrado"));
        return cliente;
    }

    public Cliente save(Cliente cliente){
       return clienteRepository.save(cliente);
    }


}
