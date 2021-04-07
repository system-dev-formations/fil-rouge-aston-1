import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LivresComponent} from './livres/livres.component';
import { AjouterLivreComponent } from './ajouter-livre/ajouter-livre.component';
import { UpdateLivreComponent } from './update-livre/update-livre.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { ShowReservationComponent }  from './show-reservation/show-reservation.component';

const routes: Routes = [
  {path : "livres", component : LivresComponent},
  {path : "ajouter-livre", component : AjouterLivreComponent},
  {path: "updateLivre/:reference", component: UpdateLivreComponent},
  { path: "", redirectTo: "livres", pathMatch: "full" },
  { path: "reservations", component: ReservationsComponent },
  { path: "reservation/:reference", component: ShowReservationComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
