package com.estudos.api.messages.services;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import com.estudos.api.authusuarios.repository.UsuarioAuthRepository;
import com.estudos.api.messages.model.GrupoModel;
import com.estudos.api.messages.repository.GrupoRepository;
import com.estudos.api.util.UtilidadesGerais;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GrupoServices {

    @Autowired
    GrupoRepository grupoRepository;

    public List<GrupoModel> listAllGrupo(){
        List<GrupoModel> models = new ArrayList<>();
        models = grupoRepository.findAll();
        return models;
    }
    public ResponseEntity<?> listaAlgunsGrupo(UUID grupoId) {
        GrupoModel models = grupoRepository.findByid(grupoId);
        if(models!=null){
            return ResponseEntity.status(HttpStatus.OK).body(models);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(null);

    }
    public ResponseEntity<?> adicionarGrupo(GrupoModel grupoModel){
        if(grupoModel.getNome().isEmpty()||grupoModel.getNome().isBlank()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Nome Grupo vazio!");
        }
        GrupoModel existGrupo = grupoRepository.findByNome(grupoModel.getNome());
        if(existGrupo != null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Já existe um grupo com esse nome!\n:"+grupoModel.getNome());
        }
        grupoModel = grupoRepository.save(grupoModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(grupoModel);
    }
}
