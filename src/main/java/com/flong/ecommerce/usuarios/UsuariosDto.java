package com.flong.ecommerce.usuarios;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuariosDto {

    private String nome;

    private String email;

    private String senha;

    private LocalDateTime dataCriacao;
}
