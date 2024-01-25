package com.defitech.pharmacie.client.reposotory;

import com.defitech.pharmacie.core.entity.Client;
import com.defitech.pharmacie.core.entity.ProduitDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client save(Client client);
    List<Client> findAll();
    void delete(Client client);
    Optional<Client> findById(Integer integer);
    Optional<Client> findByNom(String nom);
    @Query("SELECT new ProduitDetail" +
            "(pd.nomProduit, pd.qte, pd.prixUnitaire, pd.totalPartiel) " +
            "FROM ProduitDetail pd JOIN pd.facture fa " +
            "WHERE fa.date = :dateV " +
            "AND fa.client = :clientNom") // Assurez-vous que 'fa.client.nom' est valide
    List<ProduitDetail> findDetailsAchatsParClientId(@Param("dateV") LocalDate dateV, @Param("clientNom")
    String clientNom);
    @Query("SELECT new ProduitDetail" +
            "(pd.nomProduit, pd.qte, pd.prixUnitaire, pd.totalPartiel) " +
            "FROM ProduitDetail pd")
    List<ProduitDetail> findDetailsAllAchats();
    @Query("SELECT new Client(c.nom, c.adresse, c.contact), fa.total " +
            "FROM Client c JOIN Facture fa WHERE fa.client = c.nom " +
            "AND fa.date = :dateVente")
    List<Client> findClientDetailsByDateVente(@Param("dateV") LocalDate dateVente);


    @Query("SELECT new Client(c.nom, c.adresse, c.contact), fa.total " +
            "FROM Client c JOIN Facture fa " +
            "GROUP BY c.nom, c.adresse, c.contact")
    List<Client> findClientInfoEtTotalAchats();

}
