package fr.bibliotheque.reservations.service;

import fr.bibliotheque.reservations.model.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReservationService  {
    List<Reservation> getAllReservations();

    Reservation getReservationById(long idReservation);

    ResponseEntity updateReservation(long reservation);
    ResponseEntity deleteReservation(long idReservation);
}
