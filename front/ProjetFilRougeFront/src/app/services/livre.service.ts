import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Livre } from '../model/Livre';

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

  getUrgentLivres(page: number): Observable<Livre[]> {
    const href = `${this.apiURL}/urgent`;
    const requestUrl = `${href}?q=page=${page + 1}`;
    return this.http.get<Livre[]>(requestUrl);
  }
}
