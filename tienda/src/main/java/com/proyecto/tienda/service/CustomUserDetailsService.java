package com.proyecto.tienda.service;

import com.proyecto.tienda.entity.Usuario;
import com.proyecto.tienda.repository.IUsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

   private final IUsuarioRepository usuarioRepository;

   public CustomUserDetailsService(IUsuarioRepository usuarioRepository) {
       this.usuarioRepository = usuarioRepository;
   }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUserName(username);
        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(usuario.get().getUserName(),usuario.get().getPassword(), new ArrayList<>());


    }
}
