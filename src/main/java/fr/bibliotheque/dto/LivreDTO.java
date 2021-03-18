package fr.bibliotheque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class LivreDTO {

    @NotBlank
    private String titre;

    private String genre;

    @NotBlank
    private String auteur;

    private int quantite;

    private int nombreDemandes;

    private boolean commandeEnCours;
}