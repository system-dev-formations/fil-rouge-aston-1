package fr.bibliotheque.livre.service;

import fr.bibliotheque.livre.dto.LivreDTO;
import fr.bibliotheque.livre.exception.LivreAlreadyExistsException;
import fr.bibliotheque.livre.exception.LivreNotFoundException;
import fr.bibliotheque.livre.model.Livre;

import java.util.List;

public interface ILivreService {

    Livre getLivre(long reference) throws LivreNotFoundException;

    List<Livre> getAllLivres();

    long addLivre(LivreDTO livre) throws LivreAlreadyExistsException;

    long updateLivre(long reference, LivreDTO livre) throws LivreNotFoundException;

    void deleteLivre(long reference) throws LivreNotFoundException;
}
