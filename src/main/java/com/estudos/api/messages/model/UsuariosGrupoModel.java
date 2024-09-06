package com.estudos.api.messages.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "usuario_grupo")
public class UsuariosGrupoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "usuario_id")
    private UUID usuarioId;

    @Column(name = "grupo_id")
    private UUID grupoId;
}
