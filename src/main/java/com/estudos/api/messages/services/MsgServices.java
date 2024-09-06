package com.estudos.api.messages.services;

import com.estudos.api.messages.model.MsgModel;
import com.estudos.api.messages.model.UsuariosGrupoModel;
import com.estudos.api.messages.repository.MsgRepository;
import com.estudos.api.messages.repository.UsuarioGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MsgServices {

    @Autowired
    MsgRepository msgRepository;

    public List<MsgModel> listAllMsg(){
        List<MsgModel> models = new ArrayList<>();
        models = msgRepository.findAll();
        return models;
    }
    public ResponseEntity<?> listarMensagemPorDesEReme(UUID destinatario_id,
                                                       UUID remetente_id,
                                                       UUID grupo_id) {
        List<MsgModel> models = msgRepository.findByMensagemdrg(destinatario_id,remetente_id,grupo_id);
        if(models!=null){
            return ResponseEntity.status(HttpStatus.OK).body(models);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(null);

    }
    public ResponseEntity<?> enviarMensagem(MsgModel model){
        model = msgRepository.save(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(model);
    }
}
