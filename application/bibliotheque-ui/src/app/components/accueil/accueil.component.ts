import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator, PageEvent } from '@angular/material/paginator';

import { merge, Observable, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

import { Livre } from '../../model/Livre';
import { LivreService } from '../../services/livre.service';
import { Reservation } from "../../model/Reservation";
import { ReservationService } from "../../services/reservation.service";

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent {

  isLoadingResultsReservations = true;
  isRateLimitReachedReservations = false;
  isLoadingResultsCommandes = true;
  isRateLimitReachedCommandes = false;
  livreResultsLength = 5;
  livreCurrentPage = 0;
  reservationResultsLength = 5;
  reservationCurrentPage = 0;

  displayedColumnsLivres: string[] = ['reference', 'titre', 'demandes', 'quantite', 'details', 'preparer', 'valider'];
  displayedColumnsReservations: string[] = ['reference', 'dateReservation', 'name', 'details', 'preparer', 'valider'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  livres: Observable<Livre[]>;
  reservations: Observable<Reservation[]>;

  constructor(private livreService: LivreService,
              private reservationService: ReservationService,
              private router : Router) {
  }

  ngOnInit() {
     this.reservations = this.getReservations(0, 10);
     this.livres = this.getLivres(0, 10);
  }

  resetPaging(): void {
    this.paginator.pageIndex = 0;
  }

  getReservations(pageIndex: number, pageSize: number): Observable<Reservation[]> {
    this.isLoadingResultsReservations = true;
    return this.reservationService.getUrgentReservations(pageIndex, pageSize)
              .pipe(map(data => {
                  this.isLoadingResultsReservations = false;
                  this.reservationResultsLength = data.totalItems;
                  this.reservationCurrentPage = data.currentPage;
                  return data.reservations;
    }));
  }

  getLivres(pageIndex: number, pageSize: number): Observable<Livre[]> {
     this.isLoadingResultsCommandes = true;
     return this.livreService.getUrgentLivres(pageIndex, pageSize)
              .pipe(map(data => {
                  this.isLoadingResultsCommandes = false;
                  this.livreResultsLength = data.totalItems;
                  this.livreCurrentPage = data.currentPage;
                  return data.livres;
     }));
  }

  getPaginatorReservationsData(event: PageEvent) {
    this.getDailyReservations(event.pageIndex, event.pageSize);
  }

  getPaginatorLivresData(event: PageEvent) {
    this.getLivresACommander(event.pageIndex, event.pageSize);
  }

  getDailyReservations(pageIndex: number, pageSize: number) {

      this.isLoadingResultsReservations = true;

      this.reservations = this.paginator.page
      .pipe(
                  startWith({}),
                  switchMap(() => {
                    return this.reservationService.getUrgentReservations(pageIndex, pageSize);
                  }),
                  map(data => {
                    // Flip flag to show that loading has finished.
                    this.isLoadingResultsReservations = false;
                    this.isRateLimitReachedReservations = false;
                    this.reservationResultsLength = data.totalItems;
                    this.reservationCurrentPage = data.currentPage;
                    return data.reservations;
                  }),
                  catchError(() => {
                    this.isLoadingResultsReservations = false;
                    this.isRateLimitReachedReservations = true;
                    return observableOf([]);
                  })
                );
  }

  getLivresACommander(pageIndex: number, pageSize: number) {

      this.isLoadingResultsCommandes = true;

      this.livres = this.paginator.page
        .pipe(
                  startWith({}),
                  switchMap(() => {
                    return this.livreService.getUrgentLivres(pageIndex, pageSize);
                  }),
                  map(data => {
                    // Flip flag to show that loading has finished.
                    this.isLoadingResultsCommandes = false;
                    this.isRateLimitReachedCommandes = false;
                    this.livreResultsLength = data.totalItems;
                    this.livreCurrentPage = data.currentPage;
                    return data.livres;
                  }),
                  catchError(() => {
                    this.isLoadingResultsCommandes = false;
                    this.isRateLimitReachedCommandes = true;
                    return observableOf([]);
                  })
                );
  }

  preparationReservation(reference: number) {

    if (confirm("Etes-vous sûr de vouloir mettre la reservation en preparation?")) {
      this.reservationService.preparationReservation(reference)
              .subscribe(
                  () => {
                      this.reservations = this.getReservations(this.paginator.pageIndex, this.paginator.pageSize);
              });
    }
  }

  preparationCommande(reference: number) {

    if (confirm("Etes-vous sûr de vouloir mettre la commande en preparation?")) {
      this.livreService.preparationCommande(reference)
              .subscribe(
                  () => {
                      this.livres = this.getLivres(this.paginator.pageIndex, this.paginator.pageSize);
              });
    }
  }

  validateReservation(reference: number) {
    if (confirm("Etes-vous sûr de vouloir valider la reservation?")) {
      this.reservationService.validateReservation(reference)
              .subscribe(
                  () => {
                      this.reservations = this.getReservations(this.paginator.pageIndex, this.paginator.pageSize);
              });
    }
  }

  validateCommande(reference: number) {
    if (confirm("Etes-vous sûr de vouloir valider la commande?")) {
      this.livreService.validateCommande(reference)
              .subscribe(
                  () => {
                      this.livres = this.getLivres(this.paginator.pageIndex, this.paginator.pageSize);
              });
    }
  }
}
