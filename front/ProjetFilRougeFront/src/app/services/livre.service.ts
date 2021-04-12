import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { environment } from '../../environments/environment';
import { Livre } from '../model/Livre';
import { LivresPage } from '../model/LivresPage';

const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})

export class LivreService {

  apiURL: string = environment.apiUrl+'livres';
  livres: Livre[];

  constructor(private http :HttpClient) {
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Erreur: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Erreur: ${error.error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  listeLivre(): Observable<Livre[]> {
    return this.http.get<Livre[]>(this.apiURL);
  }

  ajouterLivre( livre: Livre):Observable<Livre> {
    return this.http.post<Livre>(this.apiURL, livre, httpOptions);
  }

  supprimerLivre(ref : number) {
    const url = `${this.apiURL}/${ref}`;
    return this.http.delete(url, httpOptions);
  }

  consulterLivre(reference: number): Observable<Livre> {
    const url = `${this.apiURL}/${reference}`;
    return this.http.get<Livre>(url);
  }

  updateLivre(livre : Livre) : Observable<Livre> {
    return this.http.put<Livre>(this.apiURL+"/"+livre.reference, livre, httpOptions);
  }

  getUrgentLivres(page: number, size: number): Observable<LivresPage> {
    const href = `${this.apiURL}/commandes`;
    const requestUrl = `${href}?page=${page}&size=${size}`;
    return this.http.get<LivresPage>(requestUrl);
  }

  preparationCommande(reference: number) {
    const href = `${this.apiURL}/prepare/${reference}`
    return this.http.patch(href, httpOptions).pipe(catchError(this.handleError));
  }

  validateCommande(reference: number) {
    const href = `${this.apiURL}/validate/${reference}`
    return this.http.patch(href, httpOptions).pipe(catchError(this.handleError));
  }
}
