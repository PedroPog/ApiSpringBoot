package com.estudos.api.messages.repository;

import com.estudos.api.messages.model.GrupoModel;
import com.estudos.api.messages.model.MsgModel;
import com.estudos.api.messages.model.UsuariosGrupoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsuarioGrupoRepository extends JpaRepository<UsuariosGrupoModel, UUID> {

    @Query(value = "SELECT * FROM usuario_grupo WHERE usuario_id = :usuario_id", nativeQuery = true)
    List<UsuariosGrupoModel> findByGrupoPorUsuario(@Param("usuario_id") UUID usuarioId);
}
