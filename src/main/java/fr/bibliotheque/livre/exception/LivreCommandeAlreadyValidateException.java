package fr.bibliotheque.livre.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LivreCommandeAlreadyValidateException extends Exception {

    public LivreCommandeAlreadyValidateException() {
    }

    public LivreCommandeAlreadyValidateException(String message) {
        super(message);
    }

    public LivreCommandeAlreadyValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
