package fr.bibliotheque.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Livre {

    @Id
    @GeneratedValue
    @Column
    private long idLivre;

    @Id
    @Column
    private String reference;

    @Column
    private String titre;

    @Column
    private String genre;

    @Column
    private String auteur;

    @Column
    private int quantite;

    @Column
    private int nombreDemandes;

    @Column
    private boolean commandeEnCours;

}
