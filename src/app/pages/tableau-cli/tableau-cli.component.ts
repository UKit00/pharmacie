import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Client {
  nom: string;
  adresse: string;
  email: string;
  totalAchat: number;
  selected?: boolean;
}

interface article {
  nom: string;
  quantite: number;
  prix: number;
  totalAchat: number;
}


@Component({
  selector: 'app-tableau-cli',
  standalone: true,
  imports: [CommonModule,
    FormsModule,],
  templateUrl: './tableau-cli.component.html',
  styleUrl: './tableau-cli.component.css'
})
export class TableauCliComponent {

  clients: Client[] = [];
  articles: article[] = [];

  selectClient(client: Client): void {
    client.selected = !client.selected;
  }

  isSelected(client: Client): boolean {
    return !!client.selected;
  }


  ngOnInit(): void {
    this.clients = [
      {
        nom: "Alice Smith",
        adresse: "789 Rue C",
        email: "alice.smith@example.com",
        totalAchat: 3.45
      },
      {
        nom: "Jane Doe",
        adresse: "456 Rue B",
        email: "jane.doe@example.com",
        totalAchat: 36.0
      },
      {
        nom: "John Doe",
        adresse: "123 Rue A",
        email: "john.doe@example.com",
        totalAchat: 19.48
      }
    ];
    this.articles = [
      {
        nom: "Paracétamol",
        quantite: 2,
        prix: 5.99,
        totalAchat: 11.98,
      },
      {
        nom: "Ibuprofène",
        quantite: 1,
        prix: 7.5,
        totalAchat: 7.5,
      },
      {
        nom: "Amoxicilline",
        quantite: 3,
        prix: 12.0,
        totalAchat: 36.0,
      },
      {
        nom: "Cétirizine",
        quantite: 1,
        prix: 3.45,
        totalAchat: 3.45,
      },
    ];
    this.selectClient;
  }
}
