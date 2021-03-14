package fr.bibliotheque.mapper;

import fr.bibliotheque.dto.LivreDTO;
import fr.bibliotheque.model.Livre;
import fr.bibliotheque.validator.LivreValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LivreMapper {

    private final LivreValidator livreValidator;

    public Livre mapLivreDTOToLivre(String reference, LivreDTO dto) {

        return Livre.builder()
                .reference(this.livreValidator.getReferenceOrGenerate(reference))
                .auteur(dto.getAuteur())
                .genre(this.livreValidator.getFieldOrEmpty(dto.getGenre()))
                .titre(dto.getTitre())
                .quantite(dto.getQuantite())
                .build();
    }
}
