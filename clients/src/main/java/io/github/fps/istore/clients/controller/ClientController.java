package io.github.fps.istore.clients.controller;

import io.github.fps.istore.clients.model.Client;
import io.github.fps.istore.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private  final ClientService service;

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client input){
        service.save(input);
        return ResponseEntity.ok(input);
    }

    @GetMapping("{code}")
    public ResponseEntity<Client> get(@PathVariable("code") Long code){
        return service.getClientById(code).map(ResponseEntity:: ok).orElseGet(()-> ResponseEntity.notFound().build());
    }


}
