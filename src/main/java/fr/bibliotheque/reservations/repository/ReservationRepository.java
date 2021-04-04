package fr.bibliotheque.reservations.repository;

import fr.bibliotheque.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByReference(long reference);

    @Transactional
    void deleteByReference(long reference);
}
