package com.flong.ecommerce.usuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.flong.ecommerce.usuarios.UsuariosConversor.toUsuariosDto;

@RestController
@RequestMapping(value = "/usuarios", produces = "application/json")
public class UsuariosRecurso {

    private final UsuariosServico usuariosServico;

    public UsuariosRecurso(UsuariosServico usuariosServico) {
        this.usuariosServico = usuariosServico;
    }

    @GetMapping
    public ResponseEntity<Page<UsuariosDto>> buscarUsuarios(UsuariosFiltro filtro, Pageable pageable) {
        return ResponseEntity.ok(usuariosServico.buscarUsuarios(filtro, pageable).map(UsuariosConversor::toUsuariosDto));
    }

    @PostMapping
    public ResponseEntity<UsuariosDto> cadastrarUsuario(@RequestBody UsuariosDto usuariosDto) {
        return ResponseEntity.ok(toUsuariosDto(usuariosServico.cadastrarUsuario(usuariosDto)));
    }
}
