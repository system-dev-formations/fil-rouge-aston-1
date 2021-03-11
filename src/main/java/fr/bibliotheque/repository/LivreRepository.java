package fr.bibliotheque.repository;

import fr.bibliotheque.controller.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre, String> {

}
