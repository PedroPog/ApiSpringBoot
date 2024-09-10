package com.estudos.api.authusuarios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID idusuario;

    @Column(unique = true,length = 20,nullable = false)
    @NotNull(message = "Usuario não pode ser null!")
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Email(message = "Email deve ser válido!")
    @NotNull(message = "Email não pode ser vazio!")
    private String email;

    @Column(nullable = false)
    private TipoRole role = TipoRole.USUARIO;

    public void setUsuario(String usuario){
        this.usuario = usuario.trim().toLowerCase();
    }
}
