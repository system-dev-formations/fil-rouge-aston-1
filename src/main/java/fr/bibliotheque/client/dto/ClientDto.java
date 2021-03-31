package fr.bibliotheque.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class ClientDto {

    @NotBlank
    private String nom;
    private String prenom;

    @NotBlank
    private String numeroTel;
    private Email email;

}
