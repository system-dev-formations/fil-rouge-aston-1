package fr.bibliotheque.reservations.mapper;

import fr.bibliotheque.livre.dto.LivreDTO;
import fr.bibliotheque.livre.model.Livre;
import fr.bibliotheque.reservations.dto.ReservationDto;
import fr.bibliotheque.reservations.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ReservationMapper {
    public Reservation mapReservationDTOToReservation(ReservationDto dto) {

        return Reservation.builder().dateReservation(dto.getDateReservation()).idReservation(dto.getIdReservation())
                .dateRetrait(dto.getDateRetrait())
                .client(dto.getClient()).livres(dto.getLivres()).valider(dto.isValider()).build();


    }
}
