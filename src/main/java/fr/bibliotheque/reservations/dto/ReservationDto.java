package fr.bibliotheque.reservations.dto;

import fr.bibliotheque.client.model.Client;
import fr.bibliotheque.livre.model.Livre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ReservationDto {

    private long idReservation;


    private Date dateReservation;


    private Date dateRetrait;


    private List<Livre> livres;


    private Client client;


    private boolean valider=false;}
