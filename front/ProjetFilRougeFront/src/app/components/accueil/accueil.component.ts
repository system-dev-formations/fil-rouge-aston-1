import { Component, AfterViewInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

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
export class AccueilComponent implements AfterViewInit {

  isLoadingResults = true;
  isRateLimitReached = false;

  displayedColumnsLivres: string[] = ['reference', 'titre', 'demandes', 'quantite', 'details', 'preparer', 'valider'];
  dataSourceLivre: MatTableDataSource<Livre>;
  displayedColumnsReservations: string[] = ['reference', 'dateReservation', 'name', 'details', 'preparer', 'valider'];
  dataSourceReservation: MatTableDataSource<Reservation>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  livres: Observable<Livre[]>;
  reservations: Observable<Reservation[]>;

  constructor(private livreService: LivreService,
              private reservationService: ReservationService,
              private router : Router) {
  }

  ngAfterViewInit() {
    this.livres = merge(this.paginator.page)
              .pipe(
                startWith({}),
                switchMap(() => {
                  this.isLoadingResults = true;
                  return this.livreService.getUrgentLivres(this.paginator.pageIndex);
                }),
                map(data => {
                  // Flip flag to show that loading has finished.
                  this.isLoadingResults = false;
                  this.isRateLimitReached = false;

                  return data;
                }),
                catchError(() => {
                  this.isLoadingResults = false;
                  this.isRateLimitReached = true;
                  return observableOf([]);
                })
              );
    this.reservations = merge(this.paginator.page)
              .pipe(
                startWith({}),
                switchMap(() => {
                  this.isLoadingResults = true;
                  return this.reservationService.getUrgentReservations(this.paginator.pageIndex);
                }),
                map(data => {
                  // Flip flag to show that loading has finished.
                  this.isLoadingResults = false;
                  this.isRateLimitReached = false;

                  return data;
                }),
                catchError(() => {
                  this.isLoadingResults = false;
                  this.isRateLimitReached = true;
                  return observableOf([]);
                })
              );
  }

  resetPaging(): void {
    this.paginator.pageIndex = 0;
  }
}
