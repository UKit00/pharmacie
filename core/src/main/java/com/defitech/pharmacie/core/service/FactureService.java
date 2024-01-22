package com.defitech.pharmacie.core.service;

import com.defitech.pharmacie.core.entity.Facture;
import com.defitech.pharmacie.core.entity.ProduitDetail;
import com.defitech.pharmacie.core.repository.FactureRepository;
import com.defitech.pharmacie.core.repository.IFactureService;
import com.defitech.pharmacie.core.repository.ProduitDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService implements IFactureService {
    @Autowired
    FactureRepository factureRepository;
    @Autowired
    ProduitDetailService produitDetailService;
    @Autowired
    ProduitDetailRepository produitDetailRepository;

    @Override
    public Facture ajouter(Facture f) {
        Facture fac = factureRepository.save(f);
        if (f.getProduitDetails() != null) {
            for (ProduitDetail produitDetail : f.getProduitDetails()) {
                produitDetail.setFacture(fac);
                produitDetailService.ajouter(produitDetail);
                //produitDetailRepository.save(produitDetail);
            }
        }
        return fac;
    }


    @Override
    public Facture modifier(Facture f) {
        int id = f.getNumFacture();
        Optional<Facture> factureOpt = factureRepository.findById(id);

        return factureOpt.map(facture -> {
            facture.setClient(f.getClient());
            facture.setDate(f.getDate());
            facture.setVendeur(f.getVendeur());
            facture.setModePaiement(f.getModePaiement());
            facture.getProduitDetails().clear(); // Supprimez les anciens détails des produits
            if (f.getProduitDetails() != null) {
                for (ProduitDetail produitDetail : f.getProduitDetails()) {
                    produitDetail.setFacture(facture);
                    facture.getProduitDetails().add(produitDetail);
                }
            }
            return factureRepository.save(facture);
        }).orElseThrow(() -> new RuntimeException("Facture non trouvée avec l'ID : " + id));
    }

    @Override
    public List<Facture> voirTout() {
        return factureRepository.findAll();
    }

    @Override
    public Facture voir(int id) {
        return factureRepository.findById(id).orElseThrow(() -> new RuntimeException("N'existe pas"));
    }

    @Override
    public String supprimer(int id) {
        Optional<Facture> factureOpt = factureRepository.findById(id);

        factureOpt.ifPresent(facture -> {
            // Supprimez d'abord les détails des produits associés à la facture
            produitDetailRepository.deleteAll(facture.getProduitDetails());
            // Ensuite, supprimez la facture elle-même
            factureRepository.deleteById(id);
        });
        return "Bien supprimer";
    }

}
