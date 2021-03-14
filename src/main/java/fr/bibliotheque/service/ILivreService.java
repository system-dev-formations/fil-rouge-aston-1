package fr.bibliotheque.service;

import fr.bibliotheque.dto.LivreDTO;
import fr.bibliotheque.exception.LivreAlreadyExistsException;
import fr.bibliotheque.exception.LivreNotFoundException;
import fr.bibliotheque.model.Livre;

import java.util.List;

public interface ILivreService {

    Livre getLivre(String reference) throws LivreNotFoundException;

    List<Livre> getAllLivres();

    String addLivre(LivreDTO livre) throws LivreAlreadyExistsException;

    String updateLivre(String reference, LivreDTO livre) throws LivreNotFoundException;

    void deleteLivre(String reference) throws LivreNotFoundException;
}
