package br.com.gefic.gefic.service;


import br.com.gefic.gefic.dtos.ClienteResponseDto;
import br.com.gefic.gefic.dtos.UsuarioRequestDto;
import br.com.gefic.gefic.dtos.UsuarioResponseDto;
import br.com.gefic.gefic.model.Cliente;
import br.com.gefic.gefic.model.Usuario;
import br.com.gefic.gefic.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private PasswordEncoder encoder;

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder){
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    private UsuarioResponseDto toUsuarioResponseDto(Usuario usuario) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setNome(usuario.getNome());
        dto.setEmail(dto.getEmail());
        dto.setRole(dto.getRole());
        return dto;
    }





    public UsuarioResponseDto save(UsuarioRequestDto usuarioDto){

        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(encoder.encode(usuarioDto.getPassword()));
        usuario.setRole(usuarioDto.getRole());

        usuarioRepository.save(usuario);

        return toUsuarioResponseDto(usuario);

    }

    public UsuarioResponseDto findByEmail(String email){

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("usuario não Encontrado"));;

       return toUsuarioResponseDto(usuario);
    }

}
