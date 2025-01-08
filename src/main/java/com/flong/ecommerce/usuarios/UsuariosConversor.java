package com.flong.ecommerce.usuarios;

public class UsuariosConversor {

    private UsuariosConversor() {
    }

    public static UsuariosDto toUsuariosDto(Usuarios usuarios) {
        UsuariosDto dto = new UsuariosDto();
        dto.setNome(usuarios.getNome());
        dto.setEmail(usuarios.getEmail());
        dto.setSenha(usuarios.getSenha());
        dto.setDataCriacao(usuarios.getDataCriacao());
        return dto;
    }

    public static Usuarios toUsuarios(UsuariosDto dto){
        Usuarios usuarios = new Usuarios();
        usuarios.setNome(dto.getNome());
        usuarios.setEmail(dto.getEmail());
        usuarios.setSenha(dto.getSenha());
        return usuarios;
    }
}
