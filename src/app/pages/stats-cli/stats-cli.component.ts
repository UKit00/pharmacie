import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "../header/header.component";
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CalendarComponent } from "../calendar/calendar.component";
import { TableauCliComponent } from "../tableau-cli/tableau-cli.component";

@Component({
  selector: 'app-stats-cli',
  standalone: true,
  templateUrl: './stats-cli.component.html',
  styleUrl: './stats-cli.component.css',
  imports: [RouterOutlet, HeaderComponent,
    SidebarComponent, CalendarComponent,
    TableauCliComponent]
})
export class StatsCliComponent {

}
