package fr.bibliotheque.livre.exception;

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
