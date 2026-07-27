package br.com.gefic.gefic.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDto {

    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String role;
    @NotBlank
    private String password;




}
