package com.estudos.api.messages.controller;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import com.estudos.api.authusuarios.services.UsuarioAuthServices;
import com.estudos.api.messages.model.GrupoModel;
import com.estudos.api.messages.services.GrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/grupo")
@CrossOrigin
public class GrupoController {
    @Autowired
    GrupoServices services;

    @GetMapping("/listall")
    public List<GrupoModel> listAll(){
        return services.listAllGrupo();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUsuario(@RequestBody GrupoModel model){
        return services.adicionarGrupo(model);
    }
    @GetMapping("/myList")
    public ResponseEntity<?> listAlguns(@RequestHeader UUID grupo_id){
        return services.listaAlgunsGrupo(grupo_id);
    }
}
