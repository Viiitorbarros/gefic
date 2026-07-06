package br.com.gefic.gefic.dtos;

import br.com.gefic.gefic.model.Cliente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PedidoResponseDto {


    private Date dataDaCompra;
    @NotNull
    private Date dataDaUltimaTroca;
    @NotNull
    private Date dataDoVencimento;
    @NotBlank
    private String nomeDoProduto;
    @NotNull
    private Long clienteId;


}
