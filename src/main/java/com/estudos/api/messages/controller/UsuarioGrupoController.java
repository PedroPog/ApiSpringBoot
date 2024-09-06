package com.estudos.api.messages.controller;

import com.estudos.api.messages.model.GrupoModel;
import com.estudos.api.messages.model.UsuariosGrupoModel;
import com.estudos.api.messages.services.GrupoServices;
import com.estudos.api.messages.services.UsuariosGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usugrupo")
@CrossOrigin
public class UsuarioGrupoController {
    @Autowired
    UsuariosGrupoServices services;

    @GetMapping("/listall")
    public List<UsuariosGrupoModel> listAll(){
        return services.listAllUsuarioGrupo();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUsuario(@RequestBody UsuariosGrupoModel model){
        return services.adicionarUsuarioGrupo(model);
    }
    @GetMapping("/teste")
    public ResponseEntity<?> listAlguns(@RequestHeader UUID usuario_id){
        return services.listarGruposPorUsuario(usuario_id);
    }
}
