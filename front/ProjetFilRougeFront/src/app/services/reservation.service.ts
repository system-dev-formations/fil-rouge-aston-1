import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Reservation } from '../model/Reservation';

const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})

export class ReservationService {

  apiURL: string = environment.apiUrl+'reservations';
  reservations: Reservation[];

  constructor(private http :HttpClient) {
  }


  listeReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.apiURL);
  }

  ajouterReservation( reservation: Reservation):Observable<Reservation> {
    return this.http.post<Reservation>(this.apiURL, reservation, httpOptions);
  }

  supprimerReservation(ref : number) {
    const url = `${this.apiURL}/${ref}`;
    return this.http.delete(url, httpOptions);
  }

  consulterReservation(reference: number): Observable<Reservation> {
      const url = `${this.apiURL}/${reference}`;
      return this.http.get<Reservation>(url);
  }

  updateReservation(reservation : Reservation) : Observable<Reservation> {
    return this.http.put<Reservation>(this.apiURL+"/"+reservation.reference, reservation, httpOptions);
  }

  getUrgentReservations(page: number): Observable<Reservation[]> {
    const href = `${this.apiURL}/urgent`;
    const requestUrl = `${href}?q=page=${page + 1}`;
    return this.http.get<Reservation[]>(requestUrl);
  }
}
