package fr.bibliotheque.reservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReservationAlreadyInPrepareException extends Exception {

    public ReservationAlreadyInPrepareException() {
    }

    public ReservationAlreadyInPrepareException(String message) {
        super(message);
    }

    public ReservationAlreadyInPrepareException(String message, Throwable cause) {
        super(message, cause);
    }
}
