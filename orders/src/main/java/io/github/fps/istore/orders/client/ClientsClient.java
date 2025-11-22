package io.github.fps.istore.orders.client;

import io.github.fps.istore.orders.client.representation.ClientRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clients", url="${istore.orders.clients.clients.url}")
public interface ClientsClient {
    @GetMapping("{code}")
    ResponseEntity<ClientRepresentation> get(@PathVariable("code") Long code);
}
