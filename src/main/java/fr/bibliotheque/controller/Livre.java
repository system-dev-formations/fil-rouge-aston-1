package fr.bibliotheque.controller;

import lombok.Data;

@Data
public class Livre {

    private String idLivre;
    private String titre;
    private String genre;
    private String auteur;
    private int quantite;
    private int nombreDemandes;
    private boolean commandeEnCours;

}
