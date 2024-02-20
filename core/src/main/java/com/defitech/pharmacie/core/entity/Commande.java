package com.defitech.pharmacie.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomProduit;
    private double prix;
    private int quantite;
    private double total;
    private double prixUnitaire;
    @ManyToOne(cascade = {PERSIST,MERGE})
    @JoinColumn(name = "fournisseur_id")

    private Fournisseur fournisseur;
}
