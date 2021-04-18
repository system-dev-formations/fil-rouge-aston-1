package fr.bibliotheque.reservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
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
