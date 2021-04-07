package fr.bibliotheque.livre.service;

import fr.bibliotheque.livre.constante.LivreExceptionConstante;
import fr.bibliotheque.livre.dto.LivreDTO;
import fr.bibliotheque.livre.exception.LivreAlreadyExistsException;
import fr.bibliotheque.livre.exception.LivreNotFoundException;
import fr.bibliotheque.livre.mapper.LivreMapper;
import fr.bibliotheque.livre.model.Livre;
import fr.bibliotheque.livre.repository.LivreRepository;
import fr.bibliotheque.livre.validator.LivreValidator;
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
    public Livre getLivre(long reference) throws LivreNotFoundException {
        return this.livreRepository.findByReference(reference)
                .orElseThrow(LivreNotFoundException::new);
    }

    @Override
    public List<Livre> getAllLivres() {
        return this.livreRepository.findAll();
    }

    @Override
    public long addLivre(LivreDTO livre) throws LivreAlreadyExistsException {

        livreValidator.isLivreExists(livre);
        return this.livreRepository.save(livreMapper.mapLivreDTOToLivre(livre))
                .getReference();
    }

    @Override
    public long updateLivre(long reference, LivreDTO dto) throws LivreNotFoundException {

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
    public void deleteLivre(long reference) throws LivreNotFoundException {

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
