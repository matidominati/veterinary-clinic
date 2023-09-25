package com.github.matidominati.veterinaryclinic.repository;

import com.github.matidominati.veterinaryclinic.model.Client;
import com.github.matidominati.veterinaryclinic.model.Vet;

import java.util.List;
import java.util.Optional;

public interface ClientRepo {
    Client saveClient (Client client);
    Optional<Client> deleteClient(String username);
    Optional<Client> editClient(String username, Client updatedClient);
    Optional<Client> findClientByUsername(String username);
    List<Client> getAllClients();
}
