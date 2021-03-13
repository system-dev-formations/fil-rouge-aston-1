package fr.bibliotheque.service;

import fr.bibliotheque.controller.Livre;

import java.util.List;

public interface ILivreService {
    List<Livre>  getLivres();
    String addLivre(Livre livre);
    void  removeLivre(String  Ref);
    void  editLivre(String Ref, Livre Modif);






}
