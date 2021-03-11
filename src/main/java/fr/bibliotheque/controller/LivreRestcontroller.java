package fr.bibliotheque.controller;

import fr.bibliotheque.service.ILivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreRestcontroller {
    @Autowired
    private ILivreService livreService;

    @GetMapping("livres")
    public ResponseEntity<List<Livre>> getLivres(){
        List<Livre> livres = this.livreService.getLivres();
        if (livres.isEmpty()){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(livres);
    }

}
