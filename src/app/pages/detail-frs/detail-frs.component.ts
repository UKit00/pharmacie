import { Produit } from './../../Model/produit';
import { Component, OnInit } from '@angular/core';
import { ProduitsService } from '../../services/produits.service';

@Component({
  selector: 'app-detail-frs',
  standalone: true,
  templateUrl: './detail-frs.component.html',
  styleUrls: ['./detail-frs.component.css']
})
export class DetailFrsComponent implements OnInit {
  ProduitList: Produit[] = [];
  ProduitFiltres: Produit[] = [];
  seuil: number = 5;
  boutonSelectionne: string = '';
  couleurTexte: string = '';

  constructor(private produitsService: ProduitsService) { }

  ngOnInit(): void {
    // Exemple: Chargez des données depuis le service
    this.produitsService.getSomeData().subscribe(data => {
      this.ProduitList = data;
      this.ProduitFiltres = [...this.ProduitList];
    });
  }

  afficherElementsEnDessousSeuil(): void {
    this.ProduitFiltres = this.ProduitList.filter(produit => produit.quantite < this.seuil);
    this.boutonSelectionne = 'EN DESSOUS DU SEUIL';
    this.couleurTexte = 'button-success';
  }

  afficherElementsAuDessusSeuil(): void {
    this.ProduitFiltres = this.ProduitList.filter(produit => produit.quantite >= this.seuil);
    this.boutonSelectionne = 'AU DESSUS DU SEUIL';
    this.couleurTexte = 'button-warning';
  }

  // Exemple de modification d'un fournisseur
  modifierProduit(produit: Produit): void {
    // Définissez newData avec les données réelles à mettre à jour
    const newData = { /* ... */ };
    this.produitsService.updateData(produit.id, newData).subscribe(
      (data) => {
        console.log('Réponse de la requête UPDATE :', data);
        // Traitement des données réussies
      },
      (error) => {
        console.error('Erreur lors de la requête UPDATE :', error);
        // Traitement de l'erreur
      }
    );
  }

  // Exemple de suppression d'un fournisseur
  supprimerProduit(id: number): void {
    this.produitsService.deleteData(id).subscribe(
      (data) => {
        console.log('Réponse de la requête DELETE :', data);
        // Traitement des données réussies
      },
      (error) => {
        console.error('Erreur lors de la requête DELETE :', error);
        // Traitement de l'erreur
      }
    );
  }
}
