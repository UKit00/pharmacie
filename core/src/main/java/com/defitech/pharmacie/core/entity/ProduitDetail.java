package com.defitech.pharmacie.core.entity;

import com.defitech.pharmacie.core.entity.Facture;
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
}
