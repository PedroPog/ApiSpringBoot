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
@Table(name = "grupo")
public class GrupoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grupo_id")
    private UUID grupoId;

    private String nome;
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        if (dataCriacao == null) {
            dataCriacao = LocalDateTime.now();
        }
    }
}
