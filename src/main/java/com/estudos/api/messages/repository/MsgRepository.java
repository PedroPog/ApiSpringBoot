package com.estudos.api.messages.repository;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import com.estudos.api.messages.model.MsgModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MsgRepository extends JpaRepository<MsgModel, UUID> {

    @Query(value = "SELECT * FROM mensagens WHERE destinatario_id = :destinatarioId AND" +
            "remetente_id = :remetenteId AND grupo_id = :grupoId", nativeQuery = true)
    List<MsgModel> findByMensagemdrg(@Param("destinatarioId")UUID destinatarioId,
                                     @Param("remetenteId")UUID remetenteId,
                                     @Param("grupoId")UUID grupoId);
}
