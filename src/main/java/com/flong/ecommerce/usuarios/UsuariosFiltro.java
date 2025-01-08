package com.flong.ecommerce.usuarios;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuariosFiltro {

    private Integer id;

    private String nome;

    private String email;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
