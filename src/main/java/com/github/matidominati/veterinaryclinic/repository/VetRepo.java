package com.github.matidominati.veterinaryclinic.repository;

import com.github.matidominati.veterinaryclinic.model.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepo {
    Vet saveVet (Vet vet);
    Optional<Vet> deleteVet(String username);
    Optional<Vet> editVet(String username, Vet updatedVet);
    Optional<Vet> findVetByUsername(String username);
    List<Vet> getAllVets();

}
