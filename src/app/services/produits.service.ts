import { Produit } from './../Model/produit';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  // URL de base de l'API backend
  private apiUrl = 'http://localhost:8080/api';

  // Injection du service HttpClient dans le constructeur
  constructor(private http: HttpClient) {}

  // Méthode pour effectuer une requête HTTP GET
  getSomeData(): Observable<any> {

    return this.http.get(`${this.apiUrl}/votre-endpoint-get`);
  }

  // Méthode pour effectuer une requête HTTP POST avec des données en tant que paramètre
  postData(data: any): Observable<any> {

    return this.http.post(`${this.apiUrl}/votre-endpoint-post`, data);
  }

  updateData(id: number, data: any): Observable<any> {
    // Utilisation de la méthode put du service HttpClient pour effectuer une requête PUT (mise à jour)
    return this.http.put(`${this.apiUrl}/votre-endpoint-update/${id}`, data);
  }

  deleteData(id: number): Observable<any> {
    // Utilisation de la méthode delete du service HttpClient pour effectuer une requête DELETE (suppression)
    return this.http.delete(`${this.apiUrl}/votre-endpoint-delete/${id}`);
  }


  // Exemple de gestion des réponses et des erreurs
  exempleDeRequete(): void {
    this.getSomeData().subscribe(
      (data) => {
        console.log('Réponse de la requête GET :', data);
        // Traitement des données réussies
      },
      (error) => {
        console.error('Erreur lors de la requête GET :', error);
        // Traitement de l'erreur
      }
    );

    const dataToPost = { /* ... */ };
    this.postData(dataToPost).subscribe(
      (data) => {
        console.log('Réponse de la requête POST :', data);
        // Traitement des données réussies
      },
      (error) => {
        console.error('Erreur lors de la requête POST :', error);
        // Traitement de l'erreur
      }
    );

    const updatedData = { /* ... */ };
    const idToUpdate = 123; // Remplacez par l'ID réel de la ressource à mettre à jour
    this.updateData(idToUpdate, updatedData).subscribe(
      (data) => {
        console.log('Réponse de la requête UPDATE :', data);
        // Traitement des données réussies
      },
      (error) => {
        console.error('Erreur lors de la requête UPDATE :', error);
        // Traitement de l'erreur
      }
    );

    const idToDelete = 456; // Remplacez par l'ID réel de la ressource à supprimer
    this.deleteData(idToDelete).subscribe(
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

