package br.com.gefic.gefic.service;

import br.com.gefic.gefic.dtos.ClienteRequestDto;
import br.com.gefic.gefic.dtos.ClienteResponseDto;
import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.repository.ClienteRepository;
import jakarta.el.ELException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    // Transformo um cliente em DTO
    private ClienteResponseDto toResponseDto(Cliente cliente) {
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setNome(cliente.getNome());
        dto.setNumeroTelefone(cliente.getNumeroTelefone());
        dto.setCidade(cliente.getCidade());
        dto.setEndereco(cliente.getEndereco());
        dto.setBairro(cliente.getBairro());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    public ClienteResponseDto findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não Encontrado"));
        ClienteResponseDto dto = toResponseDto(cliente);

        return dto;
    }

    public ClienteResponseDto save(ClienteRequestDto clienteDto){

        //Recebe o Dto e coloca dentro de uma entidade para ser gerada no banco
       Cliente clienteSalvo = new Cliente();

       clienteSalvo.setNome(clienteDto.getNome());
       clienteSalvo.setNumeroTelefone(clienteDto.getNumeroTelefone());
       clienteSalvo.setCidade(clienteDto.getCidade());
       clienteSalvo.setEndereco(clienteDto.getEndereco());
       clienteSalvo.setBairro(clienteDto.getBairro());
       clienteSalvo.setEmail(clienteDto.getEmail());

       clienteRepository.save(clienteSalvo);


       // Gera um dto a partir do cliente salvo no banco

       ClienteResponseDto dto = toResponseDto(clienteSalvo);

       return dto;

    }

    public List<ClienteResponseDto> findByAll (){

        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream().map(this :: toResponseDto).toList();

    }

}
