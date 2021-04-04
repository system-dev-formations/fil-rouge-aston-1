package fr.bibliotheque.reservations.mapper;

import fr.bibliotheque.reservations.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ReservationMapper {

    public Reservation mapReservationWithValidatingDate(Reservation reservation, String validatingDate) {

        reservation.setDateRetrait(LocalDate.parse(validatingDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return reservation;
    }
}
