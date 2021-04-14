import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AccueilComponent }  from './components/accueil/accueil.component';
import { LivresComponent} from './components/livres/livres.component';
import { AjouterLivreComponent } from './components/livres/ajouter-livre/ajouter-livre.component';
import { UpdateLivreComponent } from './components/livres/update-livre/update-livre.component';
import { ReservationsComponent } from './components/reservations/reservations.component';
import { ShowReservationComponent }  from './components/reservations/show-reservation/show-reservation.component';


const routes: Routes = [

  { path: "", component: AccueilComponent },
  { path: "livres", component: LivresComponent },
  { path: "ajouter-livre", component: AjouterLivreComponent },
  { path: "updateLivre/:reference", component: UpdateLivreComponent },
  { path: "reservations", component: ReservationsComponent },
  { path: "reservations/:reference", component: ShowReservationComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
