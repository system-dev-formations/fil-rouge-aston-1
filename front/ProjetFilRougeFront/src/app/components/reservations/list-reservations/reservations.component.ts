import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

import {Reservation} from "../../../model/Reservation";
import {ReservationService} from "../../../services/reservation.service";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  reservations: Reservation[];

  constructor(private reservationService: ReservationService,
              private router : Router) {
  }

  ngOnInit(): void {
    this.reservationService.listeReservations().subscribe(reservations => {
      this.reservations= reservations;
    });
  }

  supprimerReservation(reservation: Reservation) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      this.reservationService.supprimerReservation(reservation.reference).subscribe(() => {
        this.supprimerReservationDuTableau(reservation);
      });
  }

  supprimerReservationDuTableau(reservation : Reservation) {
    this.reservations.forEach((cur, index) => {
      if(reservation.reference=== cur.reference) {
        this.reservations.splice(index, 1);
      }
    });
  }
}
