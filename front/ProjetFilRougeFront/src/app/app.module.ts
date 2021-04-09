import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavBarComponent } from './components/navbar/navbar.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { LivresComponent } from './components/livres/list-livres/livres.component';
import { AjouterLivreComponent } from './components/livres/ajouter-livre/ajouter-livre.component';
import { UpdateLivreComponent } from './components/livres/update-livre/update-livre.component';
import { ReservationsComponent } from './components/reservations/list-reservations/reservations.component';
import { ShowReservationComponent }  from './components/reservations/show-reservation/show-reservation.component';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AccueilComponent,
    LivresComponent,
    AjouterLivreComponent,
    UpdateLivreComponent,
    ReservationsComponent,
    ShowReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatButtonToggleModule,
    MatTableModule,
    MatPaginatorModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
