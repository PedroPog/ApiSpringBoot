package com.estudos.api.authusuarios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class UsuarioAuthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idusuario;

    @Column(unique = true,length = 20,nullable = false)
    @NotBlank(message = "O usuario não pode estar em branco!")
    @NotNull(message = "O usuario não pode estar vazio!")
    @NotEmpty(message = "Teste")
    private String usuario;

    @Column(nullable = false,length = 6)
    private String senha;

    @Column(nullable = false)
    private TipoStatus status = TipoStatus.OFFLINE;

    public void setUsuario(String usuario){
        this.usuario = usuario.trim().toLowerCase();
    }
}
