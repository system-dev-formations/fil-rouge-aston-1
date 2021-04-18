package fr.bibliotheque.livre.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LivreAlreadyExistsException extends Exception {

    public LivreAlreadyExistsException() {
    }

    public LivreAlreadyExistsException(String message) {
        super(message);
    }

    public LivreAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
