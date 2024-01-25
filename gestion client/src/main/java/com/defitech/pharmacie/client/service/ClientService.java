package com.defitech.pharmacie.client.service;


import com.defitech.pharmacie.client.reposotory.ClientRepository;
import com.defitech.pharmacie.core.entity.Client;
import com.defitech.pharmacie.core.entity.ProduitDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClientById(Integer id) {
        return clientRepository.findById(id);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public Optional<Client> findClientByNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    public List<ProduitDetail> findDetailsAchatsParClientId(LocalDate dateV, String clientNom) {
        return clientRepository.findDetailsAchatsParClientId(dateV, clientNom);
    }

    public List<ProduitDetail> findDetailsAllAchats() {
        return clientRepository.findDetailsAllAchats();
    }

    public List<Client> findClientDetailsByDateVente(LocalDate dateVente) {
        return clientRepository.findClientDetailsByDateVente(dateVente);
    }

    public List<Client> findClientInfoEtTotalAchats() {
        return clientRepository.findClientInfoEtTotalAchats();
    }
}