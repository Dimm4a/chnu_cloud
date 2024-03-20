package com.cloud.rest.restservice.controller;

import com.cloud.rest.restservice.model.Client;
import com.cloud.rest.restservice.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getAllItems() {
        return clientRepository.findAll();
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable("id") Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @PostMapping
    public Client createItem(@RequestBody Client client) {
        return clientRepository.save(client);
    }


    @PutMapping("{id}")
    public Optional<Client> updateClient(@PathVariable Integer id, @RequestBody Client client) {
        return Optional.ofNullable(clientRepository.findById(id).map(t -> {
            t.setName(client.getName());
            t.setEmail(client.getEmail());
            t.setPhone(client.getPhone());
            return clientRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Client not found")));
    }

    @DeleteMapping("{id}")
    public void deleteClients(@PathVariable Integer id) {
        clientRepository.deleteById(id);
    }
}
