package br.com.gefic.gefic.dtos;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDto {


    private String nome;
    @NotBlank
    private String numeroTelefone;
    @Email
    private  String email;
    private String endereco;
    private String bairro;
    private String cidade;


}
