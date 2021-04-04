package fr.bibliotheque.reservations.controller;

import fr.bibliotheque.reservations.constante.ReservationExceptionConstante;
import fr.bibliotheque.reservations.exception.ReservationNotFoundException;
import fr.bibliotheque.reservations.exception.ReservationValidationException;
import fr.bibliotheque.reservations.model.Reservation;
import fr.bibliotheque.reservations.service.IReservationService;
import fr.bibliotheque.reservations.validator.ReservationValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("reservations")
public class ReservationController {

    private final IReservationService reservationService;
    private final ReservationValidator reservationValidator;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> getAllReservations() {
        log.debug("Get all reservations");
        return this.reservationService.getAllReservations();
    }

    @GetMapping(value = "/{reference}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation getReservation(@PathVariable long reference) {

        log.debug(String.format("Get reservation with reference : %d", reference));

        try {
            return this.reservationService.getReservation(reference);

        } catch(ReservationNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference),
                    e);
        }
    }

    @PatchMapping(value = "/{reference}")
    public long validateReservation(@PathVariable long reference,
                                    @RequestBody String validatingDate) {

        log.debug(String.format("Validate reservation with reference : %d at : %s", reference, validatingDate));

        try {
            reservationValidator.validateReservationValidatingDate(reference, validatingDate);
            return this.reservationService.validateReservation(reference, validatingDate);

        } catch(ReservationValidationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e);

        } catch(ReservationNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(),
                    e);

        }
    }

    @DeleteMapping(value = "/{reference}")
    public void deleteReservation(@PathVariable long reference) {

        log.debug(String.format("Delete reservation with reference : %d", reference));

        try {
            this.reservationService.deleteReservation(reference);

        }  catch(ReservationNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(),
                    e);
        }


    }
}
