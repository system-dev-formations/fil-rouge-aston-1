import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Livre } from '../../../model/Livre';
import { LivreService } from '../../../services/livre.service';


@Component({
  selector: 'app-ajouter-livre',
  templateUrl: './ajouter-livre.component.html',
  styleUrls: ['./ajouter-livre.component.css'],

})
export class AjouterLivreComponent implements OnInit {

  newLivre = new Livre();
  message :string;

  constructor(private livreService: LivreService, private router : Router) {
  }

  ngOnInit(): void {
  }

  addLivre() {
    this.livreService.ajouterLivre(this.newLivre).subscribe();
    this.router.navigate(['livres']).then(() => {
      window.location.reload();
    });
  }
}
