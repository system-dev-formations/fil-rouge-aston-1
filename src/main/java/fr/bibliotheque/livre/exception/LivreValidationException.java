package fr.bibliotheque.livre.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LivreValidationException extends  Exception {

    public LivreValidationException() {
    }

    public LivreValidationException(String message) {
        super(message);
    }

    public LivreValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
