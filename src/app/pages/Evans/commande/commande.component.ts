import { Component } from '@angular/core';
import { Router } from '@angular/router';
interface OrderItem {
  name: string;
  price: number;
  quantity: number;
  image: string;
  totalPrice: number; // This can be computed based on price * quantity
}

@Component({
  selector: 'app-order',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent {
  orderItems: OrderItem[] = [
    {
      name: 'Efalganmed',
      price: 800,
      quantity: 5,
      image: 'path_to_efalganmed_image',
      totalPrice: 4000 // This would be 800 * 5 in a real app
    },
    {
      name: 'Doliprane',
      price: 1500,
      quantity: 2,
      image: 'path_to_doliprane_image',
      totalPrice:  3000// This would be 1500 * 2 in a real app
    },
    // ... more items
  ];

  calculateTotal(items: OrderItem[]): number {
    return items.reduce((total, item) => total + item.totalPrice, 0);
  }
  constructor(private router: Router) { }

  goToLivraison() {
    this.router.navigate(['/livraison']);
  }
}
