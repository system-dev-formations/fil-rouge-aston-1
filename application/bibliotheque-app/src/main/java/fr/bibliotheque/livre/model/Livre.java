package fr.bibliotheque.livre.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "LIVRE")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livre implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private long reference;

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
    private boolean enPreparation;

    @Column
    private boolean commandeEnCours;

}
