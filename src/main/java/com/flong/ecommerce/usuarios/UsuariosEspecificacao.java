package com.flong.ecommerce.usuarios;

import com.flong.ecommerce.exception.GenericException;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class UsuariosEspecificacao {

    private UsuariosEspecificacao() {
    }

    public static Specification<Usuarios> porNome(UsuariosFiltro filtro) {
        return (root, query, criteriaBuilder) ->
                Objects.nonNull(filtro.getNome()) ? criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%") :
                        criteriaBuilder.conjunction();
    }

    public static Specification<Usuarios> porEmail(UsuariosFiltro filtro) {
        return (root, query, criteriaBuilder) ->
                Objects.nonNull(filtro.getEmail()) ? criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + filtro.getEmail().toLowerCase() + "%") :
                        criteriaBuilder.conjunction();
    }

    public static Specification<Usuarios> porId(UsuariosFiltro filtro) {
        return (root, query, criteriaBuilder) ->
                Objects.nonNull(filtro.getId()) ? criteriaBuilder.equal(root.get("id"), filtro.getId()) :
                        criteriaBuilder.conjunction();
    }

    public static Specification<Usuarios> porDataCriacao(UsuariosFiltro filtro) {
        return (root, query, criteriaBuilder) ->
                Objects.nonNull(filtro.getDataCriacao()) ? criteriaBuilder.equal(root.get("dataCriacao"), filtro.getDataCriacao()) :
                        criteriaBuilder.conjunction();
    }
}
