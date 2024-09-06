package com.estudos.api.messages.services;

import com.estudos.api.messages.model.GrupoModel;
import com.estudos.api.messages.model.UsuariosGrupoModel;
import com.estudos.api.messages.repository.GrupoRepository;
import com.estudos.api.messages.repository.UsuarioGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuariosGrupoServices {

    @Autowired
    UsuarioGrupoRepository usuarioGrupoRepository;

    public List<UsuariosGrupoModel> listAllUsuarioGrupo(){
        List<UsuariosGrupoModel> models = new ArrayList<>();
        models = usuarioGrupoRepository.findAll();
        return models;
    }
    /*public ResponseEntity<?> listarGruposPorUsuario(UUID usuario_id) {
        List<UsuariosGrupoModel> models = usuarioGrupoRepository.findByGrupoPorUsuario(usuario_id);
        if(models!=null){
            List<>
            return ResponseEntity.status(HttpStatus.OK).body(models);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(null);

    }*/
    public ResponseEntity<?> adicionarUsuarioGrupo(UsuariosGrupoModel model){
        model = usuarioGrupoRepository.save(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(model);
    }
}
