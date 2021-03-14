package fr.bibliotheque.service;

import fr.bibliotheque.constante.LivreExceptionConstante;
import fr.bibliotheque.dto.LivreDTO;
import fr.bibliotheque.exception.LivreAlreadyExistsException;
import fr.bibliotheque.exception.LivreNotFoundException;
import fr.bibliotheque.mapper.LivreMapper;
import fr.bibliotheque.model.Livre;
import fr.bibliotheque.repository.LivreRepository;
import fr.bibliotheque.validator.LivreValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class LivreServiceImpl implements ILivreService {


    private final LivreRepository livreRepository;
    private final LivreMapper livreMapper;
    private final LivreValidator livreValidator;


    @Override
    public Livre getLivre(String reference) throws LivreNotFoundException {
        log.debug(String.format("Get livre with reference : %s", reference));
        return this.livreRepository.findByReference(reference)
                .orElseThrow(LivreNotFoundException::new);
    }

    @Override
    public List<Livre> getAllLivres() {
        return this.livreRepository.findAll();
    }

    @Override
    public String addLivre(LivreDTO livre) throws LivreAlreadyExistsException {

        livreValidator.isLivreExists(livre);
        return this.livreRepository.save(livreMapper.mapLivreDTOToLivre(livre))
                .getReference();
    }

    @Override
    public String updateLivre(String reference, LivreDTO dto) throws LivreNotFoundException {

        Livre livre;
        try {
            livre = this.getLivre(reference);

        } catch (LivreNotFoundException e) {
            log.error(String.format(LivreExceptionConstante.LIVRE_REF_NOT_FOUND, reference));
            throw new LivreNotFoundException(String.format(LivreExceptionConstante.LIVRE_REF_NOT_FOUND, reference), e);
        }

        log.debug("Livre found, updating");
        return this.livreRepository.save(livreMapper.mapLivreWithDTO(livre, dto))
                .getReference();
    }


    @Override
    public void deleteLivre(String reference) throws LivreNotFoundException {

        try {
            this.getLivre(reference);

        } catch (LivreNotFoundException e) {
            log.error(String.format(LivreExceptionConstante.LIVRE_REF_NOT_FOUND, reference));
            throw new LivreNotFoundException(String.format(LivreExceptionConstante.LIVRE_REF_NOT_FOUND, reference), e);
        }

        log.debug("Livre found, deleting");
        this.livreRepository.deleteByReference(reference);
    }
}
