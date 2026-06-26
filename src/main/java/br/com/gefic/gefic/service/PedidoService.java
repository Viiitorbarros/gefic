package br.com.gefic.gefic.service;

import br.com.gefic.gefic.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {



    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository){

        this.pedidoRepository = pedidoRepository;
    }







}
