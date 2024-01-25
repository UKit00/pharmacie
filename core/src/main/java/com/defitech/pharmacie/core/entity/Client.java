package com.defitech.pharmacie.core.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCli;
    private String nom;
    @Column(nullable = true)
    private String adresse;
    @Column(nullable = true)
    private String contact;

    public Client(int idCli, String nom, String adresse, String contact) {
        this.idCli = idCli;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    public Client(String nom, String adresse, String contact) {
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    public Client() {

    }
}


