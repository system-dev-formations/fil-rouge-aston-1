package fr.bibliotheque.reservations.service;

import fr.bibliotheque.reservations.exception.ReservationNotFoundException;
import fr.bibliotheque.reservations.model.Reservation;

import java.util.List;

public interface IReservationService  {

    Reservation getReservation(long reference) throws ReservationNotFoundException;

    List<Reservation> getAllReservations();

    long validateReservation(long reference, String validatingDate) throws ReservationNotFoundException;

    void deleteReservation(long reference) throws ReservationNotFoundException;
}
