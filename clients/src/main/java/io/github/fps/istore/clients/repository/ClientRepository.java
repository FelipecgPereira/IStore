package io.github.fps.istore.clients.repository;


import io.github.fps.istore.clients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
