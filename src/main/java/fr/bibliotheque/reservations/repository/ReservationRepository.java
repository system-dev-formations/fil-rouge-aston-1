package fr.bibliotheque.reservations.repository;

import fr.bibliotheque.livre.model.Livre;
import fr.bibliotheque.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
