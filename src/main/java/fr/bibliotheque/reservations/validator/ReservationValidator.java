package fr.bibliotheque.reservations.validator;

import fr.bibliotheque.reservations.constante.ReservationExceptionConstante;
import fr.bibliotheque.reservations.exception.ReservationNotFoundException;
import fr.bibliotheque.reservations.exception.ReservationValidationException;
import fr.bibliotheque.reservations.service.IReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ReservationValidator {

    private final IReservationService reservationService;


    public void validateReservationValidatingDate(long reference, String validatingDate) throws ReservationNotFoundException, ReservationValidationException {

        log.debug("Validate reservation validation date [start]");

        try {

            this.reservationService.getReservation(reference);

            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(validatingDate,
                    DateTimeFormatter.ofPattern("dd/MM/uuuu")
                            .withResolverStyle(ResolverStyle.STRICT)
            );

        } catch(ReservationNotFoundException e) {
            log.error(String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference));
            throw new ReservationNotFoundException(String.format(ReservationExceptionConstante.RESERVATION_REF_NOT_FOUND, reference), e);

        } catch (DateTimeParseException e) {
            log.error(String.format(ReservationExceptionConstante.RESERVATION_BAD_VALIDATING_DATE, validatingDate, reference));
            throw new ReservationValidationException(String.format(ReservationExceptionConstante.RESERVATION_BAD_VALIDATING_DATE, validatingDate, reference), e);
        }
        log.debug("Validate reservation validation date [end]");
    }
}
