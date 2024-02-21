package com.defitech.pharmacie.stock.service;

import com.defitech.pharmacie.core.entity.Commande;
import com.defitech.pharmacie.core.entity.Fournisseur;
import com.defitech.pharmacie.stock.repository.CommandeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements ICommandeService {
    private final CommandeRepository commandeRepository;
    private FournisseurService fournisseurService;

    public CommandeService(CommandeRepository commandeRepository, FournisseurService fournisseurService) {
        this.commandeRepository = commandeRepository;
        this.fournisseurService = fournisseurService;
    }



    @Override
    public Commande ajouter(Commande commande) {
        Fournisseur fournisseur = this.fournisseurService.lire(commande.getFournisseur());
        commande.setFournisseur(fournisseur);
        return commandeRepository.save(commande);
    }


    @Override
    public Commande modifier(int id, Commande commande) {


        Commande command = commandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commande non trouver avec 'ID: " + id));

        command.setNomProduit(commande.getNomProduit());
        command.setTotal(commande.getTotal());
        command.setPrix(commande.getPrix());

        return commandeRepository.save(command);

        }
    @Override
    public List<Commande> voirTout() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande voir(int id) {
        return commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvée pour voir"));
    }

    @Override
    public String supprimer(int id) {
        commandeRepository.deleteById(id);
        return "Commande bien supprimée";
    }
}
