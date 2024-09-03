package com.estudos.api.authusuarios;

import com.estudos.api.authusuarios.models.UsuarioAuthModel;
import com.estudos.api.authusuarios.repository.UsuarioAuthRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioAuthServices {

    @Autowired
    UsuarioAuthRepository usuarioAuthRepository;
    @Autowired
    PasswordEncoder encoder;

    public List<UsuarioAuthModel> listUsuarioAll(){
        List<UsuarioAuthModel> models = new ArrayList<>();
        models = usuarioAuthRepository.findAll();
        return models;
    }

    public ResponseEntity<?> adicionarUsuario(@Valid UsuarioAuthModel model){
        if(model.getUsuario().isEmpty()||model.getUsuario().isBlank()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuario vazio!");
        }
        UsuarioAuthModel existUsuario = usuarioAuthRepository.findByUsuario(model.getUsuario());
        if(existUsuario != null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Já existe um usuario com esse login!\n:"+model.getUsuario());
        }
        model.setSenha(encoder.encode(model.getSenha()));
        model = usuarioAuthRepository.save(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(model);
    }

    public ResponseEntity<?> validarSenha(String usuario,String senha){
        UsuarioAuthModel model = usuarioAuthRepository.findByUsuario(usuario);
        if(model==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuario não encontrado ou desativado!");
        }
        boolean valid = encoder.matches(senha,model.getSenha());
        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Senha Incorreta!");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(model);
    }
}
