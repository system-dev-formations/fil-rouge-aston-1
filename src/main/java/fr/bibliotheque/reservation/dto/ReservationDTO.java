package fr.bibliotheque.reservation.dto;

import fr.bibliotheque.client.model.Client;
import fr.bibliotheque.livre.model.Livre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ReservationDTO {

    @NotBlank
    private long reference;

    @NotBlank
    private String dateReservation;

    private String dateRetrait;

    private boolean enPreparation;

    @NotBlank
    private List<Livre> livres;

    @NotBlank
    private Client client;

}
