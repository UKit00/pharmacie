package com.defitech.pharmacie.stock.api;

import com.defitech.pharmacie.core.entity.Commande;
import com.defitech.pharmacie.stock.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class CommandeRessource {

    private final CommandeService commandeService;

    @Autowired
    public CommandeRessource(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping("/commande")
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.ajouter(commande);
    }

    @GetMapping("/commande")
    public List<Commande> getAllCommandes() {
        return commandeService.voirTout();
    }

    @GetMapping("/commande/{id}")
    public Commande getCommandeById(@PathVariable int id) {
        return commandeService.voir(id);
    }

    @DeleteMapping("/commande/{id}")
    public String deleteCommande(@PathVariable int id) {
        return commandeService.supprimer(id);
    }

    @PutMapping("/commande")
    public Commande updateCommande(@RequestBody Commande commande) {
        return commandeService.modifier(commande);
    }
}
