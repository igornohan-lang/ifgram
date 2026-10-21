package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse criar(UserRequest request) throws Exception {
        if (repository.existsByEmail(request.email())) {
            throw new Exception( request.email());
        }
        User salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);
    }
    public UserResponse atualizarUsuario(UserRequest request) throws Exception {
        Optional<User> usuario = repository.findByEmail(request.email());
        if(usuario.isEmpty()){
            throw new Exception("usuario nao existe na base de dados.");
        }
        User usuarioSalvo = usuario.get();
        usuarioSalvo.setNome(request.nome());
        repository.save(usuarioSalvo);

        return UserResponse.from(usuarioSalvo);
    }
        public void deletarUsuario(UserRequest request) throws Exception {
            Optional<User> usuario = repository.findByEmail(request.email());
            if(usuario.isEmpty()) {
                throw new Exception("Usuario nao encontrado!");
            }
            User usuarioDeletar = usuario.get();
        }
    }


