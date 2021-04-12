package fr.bibliotheque.livre.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LivreAlreadyInPrepareException extends Exception {

    public LivreAlreadyInPrepareException() {
    }

    public LivreAlreadyInPrepareException(String message) {
        super(message);
    }

    public LivreAlreadyInPrepareException(String message, Throwable cause) {
        super(message, cause);
    }
}
