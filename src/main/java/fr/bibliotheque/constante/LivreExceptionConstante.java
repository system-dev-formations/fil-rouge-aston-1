package fr.bibliotheque.constante;

public class LivreExceptionConstante {

    public LivreExceptionConstante() throws IllegalAccessException { throw new IllegalAccessException("Utility class can't be instantiated"); }

    public final static String LIVRE_REF_NOT_FOUND = "Aucun livre n'a été trouvé pour la reference %s";
    public final static String LIVRE_ALREADY_EXISTS = "Ce livre existe déjà (auteur : %s, titre: %s)";
    public final static String LIVRE_AUTEUR_BLANK = "L'auteur du livre n'est pas renseigné";
    public final static String LIVRE_TITRE_BLANK = "Le titre du livre n'est pas renseigné";
    public final static String LIVRE_AUTEUR_AND_TITRE_BLANK = "L'auteur et le titre du livre ne sont pas renseignés";
}
