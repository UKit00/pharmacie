package com.defitech.pharmacie.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProduitDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomProduit;

    private int qte;

    private double prixUnitaire;

    private double totalPartiel;

    @ManyToOne
    @JsonIgnore
    private Facture facture;

    public ProduitDetail(String nomProduit, int qte, double prixUnitaire, double totalPartiel) {
        this.nomProduit = nomProduit;
        this.qte = qte;
        this.prixUnitaire = prixUnitaire;
        this.totalPartiel = totalPartiel;
    }

    public ProduitDetail() {

    }
}
