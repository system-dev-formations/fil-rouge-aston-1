package fr.bibliotheque.reservations.constante;

public class ReservationExceptionConstante {

    private ReservationExceptionConstante() throws IllegalAccessException { throw new IllegalAccessException("Utility class can't be instantiated"); }

    public static final String RESERVATION_REF_NOT_FOUND = "Aucune reservation n'a été trouvé pour la reference %d";
    public static final String RESERVATION_BAD_VALIDATING_DATE = "La date fournit : %s pour la reservation : %d n'est pas dans un format valide";
}
