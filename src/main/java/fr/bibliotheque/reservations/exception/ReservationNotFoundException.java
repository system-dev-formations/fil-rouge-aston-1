package fr.bibliotheque.reservations.exception;

public class ReservationNotFoundException extends Exception {

    public ReservationNotFoundException() {
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }

    public ReservationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
