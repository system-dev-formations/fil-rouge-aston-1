package fr.bibliotheque.livre.validator;

import fr.bibliotheque.livre.constante.LivreExceptionConstante;
import fr.bibliotheque.livre.dto.LivreDTO;
import fr.bibliotheque.livre.exception.LivreAlreadyExistsException;
import fr.bibliotheque.livre.exception.LivreValidationException;
import fr.bibliotheque.livre.model.Livre;
import fr.bibliotheque.livre.repository.LivreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class LivreValidator {

    private final LivreRepository livreRepository;


    public void validateLivre(LivreDTO livre) throws LivreValidationException {

        log.debug("Validate livre [start]");

        if(this.isFieldNullOrBlank(livre.getAuteur()) && this.isFieldNullOrBlank(livre.getTitre())) {
            log.error(LivreExceptionConstante.LIVRE_AUTEUR_AND_TITRE_BLANK);
            throw new LivreValidationException(LivreExceptionConstante.LIVRE_AUTEUR_AND_TITRE_BLANK);
        }

        if(this.isFieldNullOrBlank(livre.getAuteur())) {
            log.error(LivreExceptionConstante.LIVRE_AUTEUR_BLANK);
            throw new LivreValidationException(LivreExceptionConstante.LIVRE_AUTEUR_BLANK);
        }

        if(this.isFieldNullOrBlank(livre.getTitre())) {
            log.error(LivreExceptionConstante.LIVRE_TITRE_BLANK);
            throw new LivreValidationException(LivreExceptionConstante.LIVRE_TITRE_BLANK);
        }

        log.debug("Validate livre [end]");
    }

    public String getFieldOrEmpty(String field) {
        return field == null || field.isBlank() ? "" : field;
    }

    public boolean isFieldNullOrBlank(String field) {
        return field == null || field.isBlank();
    }

    public void isLivreExists(LivreDTO dto) throws LivreAlreadyExistsException {

        log.debug("Checking if livre already exists [start]");

        Livre livre = this.livreRepository.findByAuteurAndTitreIgnoreCase(dto.getAuteur(), dto.getTitre());

        if(livre != null) {
            log.error(String.format(LivreExceptionConstante.LIVRE_ALREADY_EXISTS, dto.getAuteur(), dto.getTitre()));
            throw new LivreAlreadyExistsException(String.format(LivreExceptionConstante.LIVRE_ALREADY_EXISTS, dto.getAuteur(), dto.getTitre()));
        }

        log.debug("Checking if livre already exists [end]");
    }
}
