package br.com.gefic.gefic.dtos;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteResponseDto {

    private String nome;
    private String numeroTelefone;
    private  String email;
    private String endereco;
    private String bairro;
    private String cidade;

}
