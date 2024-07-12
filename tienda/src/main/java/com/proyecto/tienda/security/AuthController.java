package com.proyecto.tienda.security;

import com.proyecto.tienda.entity.Usuario;
import com.proyecto.tienda.repository.IUsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AuthController {

    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthController(IUsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login(){
        return "usuario logeado";
    }

    @GetMapping("/register")
    public String register(){
        return "usuario registrado";
    }

    public String registerUser(@RequestParam String username, @RequestParam String password){
        Usuario usuario = new Usuario(username, passwordEncoder.encode(password));
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }
}
