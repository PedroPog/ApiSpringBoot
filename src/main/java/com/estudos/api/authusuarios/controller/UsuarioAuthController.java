package com.estudos.api.authusuarios.controller;

import com.estudos.api.authusuarios.models.TipoRole;
import com.estudos.api.authusuarios.services.UsuarioAuthServices;
import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioAuthController {
    @Autowired
    UsuarioAuthServices services;

    @GetMapping("/listall")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(services.listUsuarioAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUsuario(@RequestBody UsuarioAuthModel usuario){
        return services.adicionarUsuario(usuario);
    }
    @GetMapping("/login")
    public ResponseEntity<?> validarSenha(@RequestHeader String login,
                                          @RequestHeader String senha){
        return services.validarSenha(login,senha);
    }
}
