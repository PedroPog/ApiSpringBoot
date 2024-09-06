package com.estudos.api.messages.repository;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import com.estudos.api.messages.model.GrupoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface GrupoRepository extends JpaRepository<GrupoModel, UUID> {

    GrupoModel findByNome(String nome);

    @Query(value = "SELECT * FROM grupo WHERE grupo_id = :grupoId", nativeQuery = true)
    GrupoModel findByid(@Param("grupoId") UUID grupoId);
}
