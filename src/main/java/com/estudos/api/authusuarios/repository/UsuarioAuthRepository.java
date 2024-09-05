package com.estudos.api.authusuarios.repository;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuthModel, Long> {

    UsuarioAuthModel findByUsuario(String usuario);
}
