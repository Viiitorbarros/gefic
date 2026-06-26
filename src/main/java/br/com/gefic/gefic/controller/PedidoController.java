package br.com.gefic.gefic.controller;


import br.com.gefic.gefic.service.PedidoService;
import org.springframework.stereotype.Controller;

@Controller
public class PedidoController {


    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService ){
        this.pedidoService = pedidoService;
    }

}
