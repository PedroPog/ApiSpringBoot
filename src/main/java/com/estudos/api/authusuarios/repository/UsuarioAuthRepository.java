package com.estudos.api.authusuarios.repository;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuthModel, UUID> {

    @Query("SELECT p FROM usuario p WHERE p.usuario = :usuario;")
    UsuarioAuthModel findByUsuario(@Param("usuario") String usuario);
}
