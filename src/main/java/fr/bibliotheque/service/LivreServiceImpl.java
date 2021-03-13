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
    @Override
    public void editLivre(String Ref, Livre Modif){
       Livre editLivre = this.livreRepository.findById(Ref).orElse(null);
               this.livreRepository.save(Modif);
       }
    @Override
    public String addLivre (Livre livre) {
     Livre addlivre = this.livreRepository.save(livre);
        return addlivre.getIdLivre();
    }

    @Override
    public void removeLivre(String Ref) {
         this.livreRepository.deleteById(Ref);

    }
}
