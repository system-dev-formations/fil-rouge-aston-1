package fr.bibliotheque.service;

import fr.bibliotheque.dto.LivreDTO;
import fr.bibliotheque.exception.LivreAlreadyExistsException;
import fr.bibliotheque.exception.LivreNotFoundException;
import fr.bibliotheque.model.Livre;

import java.util.List;

public interface ILivreService {

    Livre getLivre(long reference) throws LivreNotFoundException;

    List<Livre> getAllLivres();

    long addLivre(LivreDTO livre) throws LivreAlreadyExistsException;

    long updateLivre(long reference, LivreDTO livre) throws LivreNotFoundException;

    void deleteLivre(long reference) throws LivreNotFoundException;
}
