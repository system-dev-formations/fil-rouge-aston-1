package fr.bibliotheque.controller;

import fr.bibliotheque.dto.LivreDTO;
import fr.bibliotheque.exception.LivreAlreadyExistsException;
import fr.bibliotheque.exception.LivreNotFoundException;
import fr.bibliotheque.exception.LivreValidationException;
import fr.bibliotheque.model.Livre;
import fr.bibliotheque.service.ILivreService;
import fr.bibliotheque.validator.LivreValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("livres")
public class LivreRestController {

    private final ILivreService livreService;
    private final LivreValidator livreValidator;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Livre> getAllLivres() {
        log.debug("Get all livres");
        return this.livreService.getAllLivres();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addLivre(@RequestBody LivreDTO livre) {

        log.debug(String.format("Add new livre {%s}", livre));
        try {
            livreValidator.validateLivre(livre);
            return this.livreService.addLivre(livre);

        } catch(LivreValidationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e);

        } catch(LivreAlreadyExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage(),
                    e);
        }
    }

    @PutMapping(value = "/{reference}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updatelivre(@PathVariable String reference,
                              @RequestBody LivreDTO livre) {

        log.debug(String.format("Update livre reference : %s with data : %s", reference, livre));

        try {
            livreValidator.validateLivre(livre);
            return this.livreService.updateLivre(reference, livre);

        } catch(LivreValidationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e);

        } catch(LivreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(),
                    e);
        }
    }

    @DeleteMapping(value = "/{reference}")
    public void deleteLivre(@PathVariable String reference) {

        log.debug(String.format("Delete livre with reference : %s", reference));

        try {
            this.livreService.deleteLivre(reference);

        } catch(LivreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(),
                    e);
        }
    }
}
