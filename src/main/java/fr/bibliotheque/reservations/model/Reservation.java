package fr.bibliotheque.reservations.model;

import fr.bibliotheque.client.model.Client;
import fr.bibliotheque.livre.model.Livre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Table(name = "RESERVATION")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private long reference;

    @Column
    private LocalDate dateReservation;

    @Column
    private LocalDate dateRetrait;

    @ManyToMany
    private List<Livre> livres;

    @ManyToOne
    private Client client;

}
