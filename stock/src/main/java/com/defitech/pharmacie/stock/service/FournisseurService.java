package com.defitech.pharmacie.stock.service;

import com.defitech.pharmacie.core.entity.Fournisseur;
import com.defitech.pharmacie.stock.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService implements IFournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur ajouter(Fournisseur f) {

        return fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur modifier(Fournisseur f) {
        int id = f.getId();
        Optional<Fournisseur> optFournisseur = fournisseurRepository.findById(id);
        return optFournisseur.map(fournisseur -> {
            fournisseur.setNomFournisseur(f.getNomFournisseur());
            return fournisseurRepository.save(fournisseur);
        }).orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'ID : " + id));
    }

    @Override
    public List<Fournisseur> voirTout() {

        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur voir(int id) {
        return fournisseurRepository.findById(id).orElseThrow(() -> new RuntimeException("Fournisseur non trouvé pour voir"));
    }

    @Override
    public String supprimer(int id) {
        fournisseurRepository.deleteById(id);
        return "Bien supprimé";
    }
}
