package com.estudos.api.authusuarios.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class UsuarioAuthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID idusuario;

    @Column(unique = true,length = 20,nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private TipoStatus status = TipoStatus.OFFLINE;

    public void setUsuario(String usuario){
        this.usuario = usuario.trim().toLowerCase();
    }
}
