package fr.bibliotheque.livre.constante;

public class LivreExceptionConstante {

    private LivreExceptionConstante() throws IllegalAccessException { throw new IllegalAccessException("Utility class can't be instantiated"); }

    public static final String LIVRE_REF_NOT_FOUND = "Aucun livre n'a été trouvé pour la reference %s";
    public static final String LIVRE_ALREADY_EXISTS = "Ce livre existe déjà (auteur : %s, titre: %s)";
    public static final String LIVRE_AUTEUR_BLANK = "L'auteur du livre n'est pas renseigné";
    public static final String LIVRE_TITRE_BLANK = "Le titre du livre n'est pas renseigné";
    public static final String LIVRE_AUTEUR_AND_TITRE_BLANK = "L'auteur et le titre du livre ne sont pas renseignés";
}
