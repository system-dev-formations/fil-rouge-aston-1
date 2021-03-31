package fr.bibliotheque.reservations.service;

import fr.bibliotheque.reservations.model.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReservationService  {
    List<Reservation> getAllReservations();

    ResponseEntity updateReservation(long reservation);

    Reservation getReservationById(long idReservation);
}
