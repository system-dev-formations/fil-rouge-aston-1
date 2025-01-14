import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { merge, Observable, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

import { AddLivreComponent } from './add-livre/add-livre.component';
import { UpdateLivreComponent } from './update-livre/update-livre.component';

import { Livre } from '../../model/Livre';
import { LivreService } from '../../services/livre.service';

@Component({
  selector: 'app-livres',
  templateUrl: './livres.component.html',
  styleUrls: ['./livres.component.css']
})
export class LivresComponent {

  isLoadingResults = true;
  isRateLimitReached = false;
  resultsLength = 5;
  currentPage = 0;

  displayedColumnsLivres: string[] = ['reference', 'auteur', 'titre', 'genre', 'quantite', 'details', 'supprimer'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  livres: Observable<Livre[]>;

  constructor(private livreService: LivreService,
              private router : Router,
              private dialog: MatDialog) {
  }

  ngOnInit() {
     this.livres = this.getLivres(0, 10);
  }

  resetPaging(): void {
    this.paginator.pageIndex = 0;
  }

  getLivres(pageIndex: number, pageSize: number): Observable<Livre[]> {
     this.isLoadingResults = true;
     return this.livreService.getLivres(pageIndex, pageSize)
              .pipe(map(data => {
                  this.isLoadingResults = false;
                  this.resultsLength = data.totalItems;
                  this.currentPage = data.currentPage;
                  return data.livres;
     }));
  }

  getPaginatorLivresData(event: PageEvent) {
    this.getLivresEvent(event.pageIndex, event.pageSize);
  }

  getLivresEvent(pageIndex: number, pageSize: number) {

      this.isLoadingResults = true;

      this.livres = this.paginator.page
        .pipe(
                  startWith({}),
                  switchMap(() => {
                    return this.livreService.getLivres(pageIndex, pageSize);
                  }),
                  map(data => {
                    // Flip flag to show that loading has finished.
                    this.isLoadingResults = false;
                    this.isRateLimitReached = false;
                    this.resultsLength = data.totalItems;
                    this.currentPage = data.currentPage;
                    return data.livres;
                  }),
                  catchError(() => {
                    this.isLoadingResults = false;
                    this.isRateLimitReached = true;
                    return observableOf([]);
                  })
                );
  }

  deleteLivre(reference: number) {
    if (confirm("Etes-vous sûr de vouloir supprimer ce livre?"))
        this.livreService.deleteLivre(reference)
            .subscribe(
                () => {
                    this.livres = this.getLivres(this.paginator.pageIndex, this.paginator.pageSize);
            });
  }

  addLivre(): void {
    const dialogRef = this.dialog.open(AddLivreComponent, {
      width: '25%'
    });

    dialogRef.afterClosed()
        .subscribe(
            () => {
                this.livres = this.getLivres(this.paginator.pageIndex, this.paginator.pageSize);
        });
  }

  updateLivre(livre: any): void {
    const dialogRef = this.dialog.open(UpdateLivreComponent, {
      width: '25%',
      data: {livre: livre}
    });

    dialogRef.afterClosed()
        .subscribe(
            () => {
                this.livres = this.getLivres(this.paginator.pageIndex, this.paginator.pageSize);
        });
  }
}
