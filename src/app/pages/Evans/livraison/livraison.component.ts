
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { Component } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-livraison',
  templateUrl: './livraison.component.html',
  styleUrls: ['./livraison.component.css']
})

  export class LivraisonComponent {
    constructor(private router: Router) { }

    goToCarte() {
      this.router.navigate(['/carte']);
    }

    

    goToCommande() {
      this.router.navigate(['/commande']);
    }
}
