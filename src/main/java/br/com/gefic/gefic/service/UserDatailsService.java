package br.com.gefic.gefic.service;

import br.com.gefic.gefic.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDatailsService implements UserDetailsService {


    private final UsuarioRepository usuarioRepository;

    public UserDatailsService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}
