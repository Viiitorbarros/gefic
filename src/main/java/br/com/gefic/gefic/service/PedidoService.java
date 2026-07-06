package br.com.gefic.gefic.service;

import br.com.gefic.gefic.dtos.ClienteResponseDto;
import br.com.gefic.gefic.dtos.PedidoRequestDto;
import br.com.gefic.gefic.dtos.PedidoResponseDto;
import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.model.Pedido;
import br.com.gefic.gefic.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PedidoService {



    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;



    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService){
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
    }


    // Transformo um Pedido em DTO
    public PedidoResponseDto toPedidoResponseDto(Pedido pedido){

        PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();

        pedidoResponseDto.setDataDaCompra(pedido.getDataDaCompra());
        pedidoResponseDto.setDataDoVencimento(pedido.getDataDoVencimento());
        pedidoResponseDto.setDataDaUltimaTroca(pedido.getDataDaUltimaTroca());
        pedidoResponseDto.setNomeDoProduto(pedido.getNomeDoProduto());
        pedidoResponseDto.setClienteId(pedido.getCliente().getId());


        return pedidoResponseDto;
    }


    @Transactional
    public PedidoResponseDto save (PedidoRequestDto pedidoRequestDto){

        Cliente cliente = clienteService.buscarEntidadePorId(pedidoRequestDto.getClienteId());
        Pedido pedido = new Pedido();

        pedido.setDataDaCompra(pedidoRequestDto.getDataDaCompra());
        pedido.setDataDaUltimaTroca(pedidoRequestDto.getDataDaUltimaTroca());
        pedido.setDataDoVencimento(pedidoRequestDto.getDataDoVencimento());
        pedido.setNomeDoProduto(pedidoRequestDto.getNomeDoProduto());
        pedido.setCliente(cliente);

        pedidoRepository.save(pedido);

        PedidoResponseDto pedidoDto = toPedidoResponseDto(pedido);

        return pedidoDto;

    }



    public List<PedidoResponseDto> findAll(){

        List<Pedido> listPedidos = pedidoRepository.findAll();

        return listPedidos.stream().map(this :: toPedidoResponseDto).toList();

    }


    public List<PedidoResponseDto> buscarPedidosVencidos(){

        List<Pedido> pedidosVencidos = pedidoRepository.findByDataDoVencimentoBefore(new Date());

        return pedidosVencidos.stream()
                .map(this::toPedidoResponseDto)
                .toList();

    }


}
