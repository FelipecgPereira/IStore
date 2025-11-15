package io.github.fps.istore.clients.service;

import io.github.fps.istore.clients.model.Client;
import io.github.fps.istore.clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client save(Client input){
       return repository.save(input);
    }

    public Optional<Client> getClientById(Long id){
        return repository.findById(id);
    }
}
