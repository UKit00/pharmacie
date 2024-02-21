package com.defitech.pharmacie.core.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomFournisseur;

    private String adress;

    private String numero;
    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    private List<Commande> commandes;

    public int getId() {
        return id;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public String getAdress() {
        return adress;
    }

    public String getNumero() {
        return numero;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}

