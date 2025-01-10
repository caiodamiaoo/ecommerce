package com.flong.ecommerce.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long>, JpaSpecificationExecutor<Usuarios> {
    boolean existsUsuariosByEmail(String email);
}
