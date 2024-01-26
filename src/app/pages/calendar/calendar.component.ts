import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css'],
  imports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    FormsModule// Assurez-vous d'importer ReactiveFormsModule pour les formulaires réactifs
  ],
  standalone: true
})
export class CalendarComponent {
  selectedDate: Date | undefined;

  constructor() { }

  // Vous pouvez ajouter une fonction pour traiter la date sélectionnée si nécessaire
  processDate() {
    console.log(this.selectedDate);
  }

}
