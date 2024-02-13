package com.defitech.pharmacie.stock.service;

import com.defitech.pharmacie.core.entity.Commande;
import com.defitech.pharmacie.core.entity.Fournisseur;
import com.defitech.pharmacie.stock.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Commande modifier(Commande commande) {
        int id = commande.getId();
        Optional<Commande> optCommande = commandeRepository.findById(id);
        return optCommande.map(cmd -> {

            cmd.setNomProduit(commande.getNomProduit());
            cmd.setPrix(commande.getPrix());
            cmd.setQuantite(commande.getQuantite());
            return commandeRepository.save(cmd);
        }).orElseThrow(() -> new RuntimeException("Commande non trouvée avec l'ID : " + id));
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
