package fr.bibliotheque.mapper;

import fr.bibliotheque.dto.LivreDTO;
import fr.bibliotheque.model.Livre;
import fr.bibliotheque.validator.LivreValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class LivreMapper {

    private final LivreValidator livreValidator;

    public Livre mapLivreDTOToLivre(LivreDTO dto) {

        return Livre.builder()
                .auteur(dto.getAuteur())
                .genre(this.livreValidator.getFieldOrEmpty(dto.getGenre()))
                .titre(dto.getTitre())
                .quantite(dto.getQuantite())
                .build();
    }

    public Livre mapLivreWithDTO(Livre livre, LivreDTO dto) {

        livre.setAuteur(dto.getAuteur());
        if(!this.livreValidator.isFieldNullOrBlank(dto.getGenre())) {
            livre.setGenre(dto.getGenre());
        }
        livre.setTitre(dto.getTitre());
        livre.setQuantite(dto.getQuantite());
        return livre;
    }
}
