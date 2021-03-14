package fr.bibliotheque.exception;

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
