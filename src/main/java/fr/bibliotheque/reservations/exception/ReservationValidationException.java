package fr.bibliotheque.reservations.exception;

public class ReservationValidationException extends  Exception {

    public ReservationValidationException() {
    }

    public ReservationValidationException(String message) {
        super(message);
    }

    public ReservationValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
