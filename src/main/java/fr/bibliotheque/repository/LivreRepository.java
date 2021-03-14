package fr.bibliotheque.repository;

import fr.bibliotheque.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LivreRepository extends JpaRepository<Livre, String> {

    Optional<Livre> findByReference(String reference);

    Livre findByAuteurAndTitreIgnoreCase(String auteur, String titre);

    @Transactional
    void deleteByReference(String reference);
}
