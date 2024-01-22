package com.defitech.pharmacie.core.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numFacture;

    private String client;

    @Column(nullable = true)
    private LocalDate date;

    private String vendeur;

    private String modePaiement;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.MERGE)
    private List<ProduitDetail> produitDetails;
//
//    @Lob
//    @Column(columnDefinition = "TEXT")
//    private String produitDetailsJson;

    private Double total;

//    public void convertirProduitDetailsEnJson() {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            this.produitDetailsJson = objectMapper.writeValueAsString(produitDetails);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sauvegarderFacture() {
//        convertirProduitDetailsEnJson();
//    }
}
