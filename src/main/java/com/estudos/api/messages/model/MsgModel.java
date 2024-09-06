package com.estudos.api.messages.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "mensagens")
public class MsgModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mensagem_id", columnDefinition = "uuid")
    private UUID mensagemId;

    private String texto;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @Column(name = "remetente_id")
    private UUID remetenteId;

    @Column(name = "destinatario_id")
    private UUID destinatarioId;

    @Column(name = "grupo_id")
    private UUID grupoId;
}
