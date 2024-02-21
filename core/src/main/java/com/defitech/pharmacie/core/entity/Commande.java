package com.defitech.pharmacie.core.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
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

    public int getId() {
        return id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getTotal() {
        return total;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
