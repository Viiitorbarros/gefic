package br.com.gefic.gefic.controller;


import br.com.gefic.gefic.dtos.PedidoRequestDto;
import br.com.gefic.gefic.dtos.PedidoResponseDto;
import br.com.gefic.gefic.model.Pedido;
import br.com.gefic.gefic.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pedido")
public class PedidoController {


    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService ){
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public PedidoResponseDto save (@RequestBody PedidoRequestDto pedidoRequestDto){

        PedidoResponseDto novoPedido = pedidoService.save(pedidoRequestDto);

        return novoPedido;

    }

    @GetMapping
    public List<PedidoResponseDto> findAll(){

        List<PedidoResponseDto> listPedidos = pedidoService.findAll();

        return  listPedidos;

    }

    @GetMapping("/vencidos")
    public List<PedidoResponseDto> buscarPedidosVencidos(){

        List<PedidoResponseDto> pedidosVencidos = pedidoService.buscarPedidosVencidos();

        return pedidosVencidos;
    }


}
