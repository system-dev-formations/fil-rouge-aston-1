package fr.bibliotheque.exception;

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
