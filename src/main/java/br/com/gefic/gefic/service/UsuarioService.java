package br.com.gefic.gefic.service;


import br.com.gefic.gefic.model.Usuario;
import br.com.gefic.gefic.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario findByEmail(String email){

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("usuario não Encontrado"));;

        return usuario;
    }

}
