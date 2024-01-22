package com.defitech.pharmacie.core.api;

import com.defitech.pharmacie.core.entity.Facture;
import com.defitech.pharmacie.core.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caisse")
public class FactureRessource {

    @Autowired
    FactureService factureService;

    @PostMapping("/facture")
    public Facture generer(@RequestBody Facture f){
        return factureService.ajouter(f);
    }

    @GetMapping("/facture")
    public List<Facture> lire(){
        return factureService.voirTout();
    }

    @GetMapping("/facture/{id}")
    public Facture voir(@PathVariable("id") int id){
        return factureService.voir(id);
    }

    @DeleteMapping("/facture/{id}")
    public String sup(@PathVariable("id") int id){
        return factureService.supprimer(id);
    }

    @PutMapping("/facture")
    public Facture modifier(@RequestBody Facture f){
        return factureService.modifier(f);
    }
}
