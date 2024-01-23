package com.defitech.pharmacie.stock.api;

import com.defitech.pharmacie.core.entity.Produit;
import com.defitech.pharmacie.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class ProduitRessource {

    @Autowired
    ProduitService produitService;

    @PostMapping("/produit")
    public Produit generer(@RequestBody Produit p){
        return produitService.ajouter(p);
    }

    @GetMapping("/produit")
    public List<Produit> lire(){
        return produitService.voirTout();
    }

    @GetMapping("/produit/{id}")
    public Produit voir(@PathVariable("id") int id){
        return produitService.voir(id);
    }

    @DeleteMapping("/produit/{id}")
    public String sup(@PathVariable("id") int id){
        return produitService.supprimer(id);
    }

    @PutMapping("/produit")
    public Produit modifier(@RequestBody Produit p){
        return produitService.modifier(p);
    }

}
