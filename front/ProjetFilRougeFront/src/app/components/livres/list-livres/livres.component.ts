import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Livre } from '../../../model/Livre';
import { LivreService } from '../../../services/livre.service';

@Component({
  selector: 'app-livres',
  templateUrl: './livres.component.html',
  styleUrls: ['./livres.component.css']
})
export class LivresComponent implements OnInit {

  livres: Livre[];
  constructor(private livreService: LivreService,
    private router : Router) {
  }

  ngOnInit(): void {
    this.livreService.listeLivre().subscribe(livres => {
      this.livres= livres;
    });
  }

  supprimerLivre(livre: Livre) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
    this.livreService.supprimerLivre(livre.reference).subscribe(() => {
      this.supprimerLivreDuTableau(livre);
    });

  }

  supprimerLivreDuTableau(livre : Livre) {
    this.livres.forEach((cur, index) => {
      if(livre.reference=== cur.reference) {
        this.livres.splice(index, 1);
      }
    });
  }
}
