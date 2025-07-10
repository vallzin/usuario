package com.javanauta.usuario.business;

import com.javanauta.usuario.business.converter.UsuarioConverter;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import com.javanauta.usuario.infrastructure.exceptions.ConflictExcepeion;
import com.javanauta.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.usuario.infrastructure.repository.UsuarioRepository;
import com.javanauta.usuario.infrastructure.security.JwtUtil;
import org.springframework.boot.context.config.ConfigDataException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioConverter usuarioConverter,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioConverter = usuarioConverter;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }

    public void emailExiste(String email){
        try {
            boolean existe = verificaEmailExiste(email);
            if (existe){
                throw new ConcurrentModificationException("Email já cadastrado " + email);
            }
        }catch (ConfigDataException e){
            throw new ConflictExcepeion("Email já cadastrado " , e.getCause());

        }
    }

    public Usuario buscarUsuarioByEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado" + email)
        );
    }

    public void deletaUsuarioByEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }

    public boolean verificaEmailExiste(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO dto){
        String email = jwtUtil.extractEmailToken(token.substring(7));
        dto.setSenha(dto.getSenha() != null ? passwordEncoder.encode(dto.getSenha()) : null);
        Usuario usuarioEntity = usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não localizado")
        );
        Usuario usuario = usuarioConverter.updateUsuario(dto, usuarioEntity);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }


}
