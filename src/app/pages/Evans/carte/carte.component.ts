import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carte',
  standalone: true,
  imports: [],
  templateUrl: './carte.component.html',
  styleUrl: './carte.component.css'
})
export class CarteComponent {
  constructor(private router: Router) { }

  goToConfirmation() {
    this.router.navigate(['/confirmation']);
  }
  goToLivraison() {
    this.router.navigate(['/livraison']);
  }

}
