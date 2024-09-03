package com.estudos.api.authusuarios.controller;

import com.estudos.api.authusuarios.UsuarioAuthServices;
import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UsuarioAuthModel> listAll(){
        return services.listUsuarioAll();
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
