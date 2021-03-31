package fr.bibliotheque.reservations.model;
import fr.bibliotheque.client.model.Client;
import fr.bibliotheque.livre.model.Livre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Table(name = "RESERVATION")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation implements Serializable{
    @Id
    @GeneratedValue
    @Column
    private long idReservation;

    @Column
    private Date dateReservation;

    @Column
    private Date dateRetrait;

    @OneToMany
    private List<Livre> livres;

    @OneToOne
    private Client client;

    @Column
    private boolean valider=false;


}
