package br.com.gefic.gefic.dtos;


import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UsuarioResponseDto {


    private String nome;
    @Email
    private String email;
    private String role;


}
