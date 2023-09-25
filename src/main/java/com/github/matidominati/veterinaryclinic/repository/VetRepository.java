package com.github.matidominati.veterinaryclinic.repository;

import com.github.matidominati.veterinaryclinic.model.User;
import com.github.matidominati.veterinaryclinic.model.Vet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VetRepository implements VetRepo{
    private final List<Vet> vets = new ArrayList<>();

    @Override
    public Vet saveVet(Vet vet) {
        vets.add(vet);
        return vet;
    }

    @Override
    public Optional<Vet> deleteVet(String username) {
        Optional<Vet> vetToDelete = findVetByUsername(username);
        if(vetToDelete.isEmpty()){
            return Optional.empty();
        }
        vets.remove(vetToDelete.get());
        return vetToDelete;
    }

    @Override
    public Optional<Vet> editVet(String username, Vet updatedVet) {
        Optional<Vet> optionalVet = findVetByUsername(username);
        if(optionalVet.isEmpty()){
            return Optional.empty();
        }
        Vet vetToEdit = optionalVet.get();
        vetToEdit.setSpecialization(updatedVet.getSpecialization());
        vetToEdit.setName(updatedVet.getName());
        vetToEdit.setSurname(updatedVet.getSurname());
        vetToEdit.setPhoneNumber(updatedVet.getPhoneNumber());
        vetToEdit.setYearsOfExperience(updatedVet.getYearsOfExperience());
        vetToEdit.setWorkStartTime(updatedVet.getWorkStartTime());
        vetToEdit.setWorkEndTime(updatedVet.getWorkEndTime());
        vetToEdit.setPassword(updatedVet.getPassword());
        return Optional.ofNullable(vetToEdit);
    }

    @Override
    public Optional<Vet> findVetByUsername(String username) {
        return vets.stream()
                .filter(user -> user.getUsername() != null && user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public List<Vet> getAllVets() {
        return vets;
    }
}
