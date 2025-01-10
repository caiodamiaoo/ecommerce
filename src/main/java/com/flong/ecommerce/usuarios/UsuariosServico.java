package com.flong.ecommerce.usuarios;

import com.flong.ecommerce.exception.EntidadeExistenteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.flong.ecommerce.usuarios.UsuariosConversor.toUsuarios;
import static com.flong.ecommerce.usuarios.UsuariosEspecificacao.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class UsuariosServico {

    private final UsuariosRepositorio usuariosRepositorio;

    public UsuariosServico(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }

    @Transactional
    public Page<Usuarios> buscarUsuarios(UsuariosFiltro filtro, Pageable pageable) {
        return usuariosRepositorio.findAll(where(porNome(filtro))
                .and(porEmail(filtro))
                .and(porId(filtro))
                .and(porDataCriacao(filtro)), pageable);
    }

    @Transactional
    public Usuarios cadastrarUsuario(UsuariosDto dto) {
        if (validaEmail(dto.getEmail())) {
            throw new EntidadeExistenteException("Usuário já cadastrado");
        }
        return usuariosRepositorio.save(toUsuarios(dto));
    }

    public boolean validaEmail(String email) {
        return usuariosRepositorio.existsUsuariosByEmail(email);
    }
}
