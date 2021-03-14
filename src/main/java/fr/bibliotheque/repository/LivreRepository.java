package fr.bibliotheque.repository;

import fr.bibliotheque.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre, String> {

    Livre findByAuteurAndTitreIgnoreCase(String auteur, String titre);
}
