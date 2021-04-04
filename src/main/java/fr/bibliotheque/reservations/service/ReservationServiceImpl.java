package fr.bibliotheque.reservations.service;

import fr.bibliotheque.reservations.constante.ReservationExceptionConstante;
import fr.bibliotheque.reservations.exception.ReservationNotFoundException;
import fr.bibliotheque.reservations.mapper.ReservationMapper;
import fr.bibliotheque.reservations.model.Reservation;
import fr.bibliotheque.reservations.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;


    @Override
    public Reservation getReservation(long reference) throws ReservationNotFoundException {
        return this.reservationRepository.findByReference(reference)
                .orElseThrow(ReservationNotFoundException::new);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public long validateReservation(long reference, String validatingDate) throws ReservationNotFoundException {

        Reservation reservation;
        try {
            reservation = this.getReservation(reference);

        } catch(ReservationNotFoundException e) {
            log.error(String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference), e);
            throw new ReservationNotFoundException(String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference), e);
        }

        log.debug("Reservation found, validating");
        return this.reservationRepository
                .save(reservationMapper.mapReservationWithValidatingDate(reservation, validatingDate))
                .getReference();
    }

    @Override
    public void deleteReservation(long reference) throws ReservationNotFoundException {

        try {
            this.getReservation(reference);

        } catch (ReservationNotFoundException e) {
            log.error(String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference));
            throw new ReservationNotFoundException(String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference), e);
        }

        log.debug("Reservation found, deleting");
        this.reservationRepository.deleteByReference(reference);

    }
}
