import { Component, OnInit } from '@angular/core';
import { Produit } from '../../../Model/produit';

@Component({
  selector: 'app-page-suivi',
  standalone: true,
  imports: [],
  templateUrl: './page-suivi.component.html',
  styleUrl: './page-suivi.component.css'
})
export class PageSuiviComponent  implements OnInit{


    ProduitList: Produit[] = [];
    produitsComplets: Produit[] = [];
    produitsFiltres: Produit[] = [];
    boutonSelectionne: string = '';
    couleurTexte: string = '';
    couleurBoutonSelectionne: string = '';

    constructor() { }

    ngOnInit(): void {
      // Initialiser les deux tableaux
      this.produitsComplets = [...this.ProduitList];
      this.produitsFiltres = [...this.ProduitList];
    }
    

    afficherElementsEnDessousSeuil(): void {
      this.produitsFiltres = this.ProduitList.filter(produit => produit.quantite < produit.seuil);
      this.boutonSelectionne = 'EN DESSOUS DU SEUIL';
      this.couleurTexte = 'button-success';
    }

    afficherElementsAuDessusSeuil(): void {
      this.produitsFiltres = this.ProduitList.filter(produit => produit.quantite >= produit.seuil);
      this.boutonSelectionne = 'AU DESSUS DU SEUIL';
      this.couleurTexte = 'button-warning';
    }



}

