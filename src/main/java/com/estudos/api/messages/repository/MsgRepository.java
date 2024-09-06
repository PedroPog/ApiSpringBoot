package com.estudos.api.messages.repository;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import com.estudos.api.messages.model.MsgModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MsgRepository extends JpaRepository<MsgModel, UUID> {

}
