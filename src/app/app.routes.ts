import { PageStatistiqueComponent } from './pages/page-statistique/page-statistique.component';
import { Routes } from '@angular/router';
import { PageDashboardComponent } from './pages/page-dashboard/page-dashboard.component';
import { PageProduitComponent } from './pages/Stock/page-produit/page-produit.component';
import { PageSuiviComponent } from './pages/Stock/page-suivi/page-suivi.component';
import { PageClientComponent } from './pages/Client/page-client/page-client.component';
import { PageRapportClientComponent } from './pages/Client/page-rapport-client/page-rapport-client.component';
import { PageCaisseComponent } from './pages/ventes/page-caisse/page-caisse.component';
import { PageRapportVenteComponent } from './pages/ventes/page-rapport-vente/page-rapport-vente.component';
import { PageCommandeComponent } from './pages/Stock/page-commande/page-commande.component';
import { PageAproposComponent } from './pages/page-apropos/page-apropos.component';
import { PageGeneralComponent } from './pages/page-general/page-general.component';
import { RapportpersonnelComponent } from './pages/Personnel/rapportpersonnel/rapportpersonnel.component';
import { PagePersonnelComponent } from './pages/Personnel/page-personnel/page-personnel.component';
import { ProduitpageComponent } from './produitpage/produitpage.component';
import { CommandeComponent } from './pages/Evans/commande/commande.component';


export const routes: Routes = [

    {
        path: '',
        component: PageDashboardComponent,
        children: [

          /*STOCK*/
          {
            path: 'produit',
            component : PageProduitComponent
          },
          {
            path: 'commande',
            component :CommandeComponent
          },
          {
            path: 'suivi',
            component : PageSuiviComponent
          },
          /*Clients*/
          {
            path: 'client',
            component : PageClientComponent
          },
          {
            path: 'rapport',
            component : PageRapportClientComponent
          },
          /*Ventes*/
          {
            path: 'vente',
            component : PageCaisseComponent
          },
          {
            path: 'rapportVente',
            component : PageRapportVenteComponent
          },
          {
            path: 'a propos',
            component : PageAproposComponent
          },
          {
            path: 'general',
            component : PageGeneralComponent
          },
          {
            path: 'rapport personnel',
            component :RapportpersonnelComponent
          },
          {
            path: 'personnel',
            component : PagePersonnelComponent
          },
          {
            path: 'personnel',
            component : PagePersonnelComponent
          },
          {
            path: 'test',
            component :ProduitpageComponent
          }
        ]
    },

];

