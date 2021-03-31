package fr.bibliotheque.reservations.service;

import fr.bibliotheque.reservations.mapper.ReservationMapper;
import fr.bibliotheque.reservations.model.Reservation;
import fr.bibliotheque.reservations.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ReservationServiceImpl implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public ResponseEntity updateReservation(long reservationDto) {

        Optional<Reservation> reservation = this.reservationRepository.findById(reservationDto);
        if (reservation.isPresent()) {
            Reservation reservation1 = reservation.get();
            reservation1.setValider(true);
            reservation1.setDateRetrait(new Date());
            this.reservationRepository.save(reservation1);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Override
    public Reservation getReservationById(long idReservation) {
        return this.reservationRepository.findById(idReservation).get();
    }

}
