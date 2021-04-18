package fr.bibliotheque.livre.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LivreNotFoundException extends Exception {

    public LivreNotFoundException() {
    }

    public LivreNotFoundException(String message) {
        super(message);
    }

    public LivreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
