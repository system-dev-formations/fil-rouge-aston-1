package fr.bibliotheque.client.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "CLIENT")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private long reference;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String numeroTel;

    @Column
    private String email;
}
