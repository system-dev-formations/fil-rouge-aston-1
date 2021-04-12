package fr.bibliotheque.reservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReservationAlreadyValidateException extends Exception {

    public ReservationAlreadyValidateException() {
    }

    public ReservationAlreadyValidateException(String message) {
        super(message);
    }

    public ReservationAlreadyValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
