package com.defitech.pharmacie.stock.api;

import com.defitech.pharmacie.core.entity.Fournisseur;
import com.defitech.pharmacie.stock.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class FournisseurResource {

    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurResource(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping("/fournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.ajouter(fournisseur);
    }

    @GetMapping("/fournisseur")
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.voirTout();
    }

    @GetMapping("/fournisseur/{id}")
    public Fournisseur getFournisseurById(@PathVariable int id) {
        return fournisseurService.voir(id);
    }

    @DeleteMapping("/fournisseur/{id}")
    public String deleteFournisseur(@PathVariable int id) {
        return fournisseurService.supprimer(id);
    }

    @PutMapping("/fournisseur")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.modifier(fournisseur);
    }
}
