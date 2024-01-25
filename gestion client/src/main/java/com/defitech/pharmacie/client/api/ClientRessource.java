package com.defitech.pharmacie.client.api;


import com.defitech.pharmacie.client.service.ClientService;
import com.defitech.pharmacie.core.entity.Client;
import com.defitech.pharmacie.core.entity.ProduitDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientRessource {

    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.ok().body(Map.of(
                "message", "Client créé avec succès",
                "client", savedClient
        ));
    }


    @GetMapping("/list")
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/search/{nom}")
    public ResponseEntity<?> findClientByNom(@PathVariable String nom) {
        Optional<Client> client = clientService.findClientByNom(nom);
        return client
                .map(value -> ResponseEntity.ok().body(Map.of(
                        "message", "Client trouvé",
                        "client", value
                )))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Client non trouvé")));
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id) {
        return clientService.findClientById(id)
                .map(client -> ResponseEntity.ok().body(Map.of(
                        "message", "Client trouvé",
                        "client", client
                )))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Client non trouvé")));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Integer id, @RequestBody Client clientDetails) {
        return clientService.findClientById(id)
                .map(client -> {
                    client.setNom(clientDetails.getNom());
                    client.setAdresse(clientDetails.getAdresse());
                    client.setContact(clientDetails.getContact());
                    // Mettre à jour les autres champs si nécessaire
                    Client updatedClient = clientService.saveClient(client);
                    return ResponseEntity.ok().body(Map.of(
                            "message", "Client mis à jour avec succès",
                            "client", updatedClient
                    ));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Client non trouvé pour mise à jour")));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
        return clientService.findClientById(id)
                .map(client -> {
                    clientService.deleteClient(client);
                    return ResponseEntity.ok().body(Map.of("message", "Client supprimé avec succès"));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Client non trouvé pour suppression")));
    }

    @GetMapping("/detailsAchats")
    public List<ProduitDetail> findDetailsAchatsParClientId(
            @RequestParam("dateV") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateV,
            @RequestParam("clientNom") String clientNom) {
        return clientService.findDetailsAchatsParClientId(dateV, clientNom);
    }

    @GetMapping("/detailsAllAchats")
    public List<ProduitDetail> findDetailsAllAchats() {
        return clientService.findDetailsAllAchats();
    }

    @GetMapping("/clientsByDateVente/{dateVente}")
    public List<Client> findClientDetailsByDateVente(
            @PathVariable("dateVente") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateVente) {
        return clientService.findClientDetailsByDateVente(dateVente);
    }

    @GetMapping("/clientsInfoEtTotalAchats")
    public List<Client> findClientInfoEtTotalAchats() {
        return clientService.findClientInfoEtTotalAchats();
    }


}
