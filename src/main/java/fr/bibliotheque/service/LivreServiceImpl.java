package fr.bibliotheque.service;

import fr.bibliotheque.controller.Livre;
import fr.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivreServiceImpl implements ILivreService{
    @Autowired
    private LivreRepository livreRepository;


    @Override
    public List<Livre> getLivres() {

        return this.livreRepository.findAll();

    }
}
