package fr.bibliotheque.reservations.controller;

import fr.bibliotheque.livre.dto.LivreDTO;
import fr.bibliotheque.livre.exception.LivreNotFoundException;
import fr.bibliotheque.livre.exception.LivreValidationException;
import fr.bibliotheque.livre.model.Livre;
import fr.bibliotheque.livre.service.ILivreService;
import fr.bibliotheque.livre.validator.LivreValidator;
import fr.bibliotheque.reservations.dto.ReservationDto;
import fr.bibliotheque.reservations.model.Reservation;
import fr.bibliotheque.reservations.service.IReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("reservation")
public class ReservationController {
    private IReservationService reservationService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> getAllReservations() {
        log.debug("Get all reservations");
        return this.reservationService.getAllReservations();
    }

    @GetMapping(value = "/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation getReservation(@PathVariable long idReservation) {
        log.debug("Get reservations");
        return this.reservationService.getReservationById(idReservation);
    }

    @PutMapping(value = "/{idReservation}")
    public ResponseEntity updateReservation(@PathVariable long idReservation) {
        if (idReservation > 0) {

            return this.reservationService.updateReservation(idReservation);

        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping(value = "/{idReservation}")
    public ResponseEntity deleteReservation(@PathVariable long idReservation) {

        log.debug(String.format("Delete reservation with idReservation : %s", idReservation));

        if (idReservation > 0) {

            return this.reservationService.deleteReservation(idReservation);

        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
