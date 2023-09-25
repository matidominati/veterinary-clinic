package com.github.matidominati.veterinaryclinic.repository;

import com.github.matidominati.veterinaryclinic.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements ClientRepo {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public Client saveClient(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public Optional<Client> deleteClient(String username) {
        Optional<Client> clientToDelete = findClientByUsername(username);
        if (clientToDelete.isEmpty()) {
            return Optional.empty();
        }
        clients.remove(clientToDelete.get());
        return clientToDelete;
    }

    @Override
    public Optional<Client> editClient(String username, Client updatedClient) {
        Optional<Client> optionalClient = findClientByUsername(username);
        if (optionalClient.isEmpty()) {
            return Optional.empty();
        }
        Client clientToEdit = optionalClient.get();
        clientToEdit.setName(updatedClient.getName());
        clientToEdit.setSurname(updatedClient.getSurname());
        clientToEdit.setPassword(updatedClient.getPassword());
        clientToEdit.setPets(updatedClient.getPets());
        clientToEdit.setPhoneNumber(updatedClient.getPhoneNumber());
        return Optional.ofNullable(clientToEdit);
    }

    @Override
    public Optional<Client> findClientByUsername(String username) {
        return clients.stream()
                .filter(client -> client.getUsername() != null && client.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }
}
