import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Livre } from '../../../model/Livre';
import { LivreService } from '../../../services/livre.service';


@Component({
  selector: 'app-update-livre',
  templateUrl: './update-livre.component.html',
  styles: [
  ]
})
export class UpdateLivreComponent implements OnInit {

  currentLivre = new Livre();

  constructor(private activatedRoute: ActivatedRoute,
              private router : Router,
              private livreService: LivreService) {
  }

  ngOnInit(): void {
    this.livreService.consulterLivre(this.activatedRoute.snapshot.params.reference)
      .subscribe( livre => { this.currentLivre = livre; } ) ;
  }

  updateLivre() {
    this.livreService.updateLivre(this.currentLivre).subscribe( () => {
      this.router.navigate(['livres' ]);
    }, (error) => { alert("Problème lors de la modification !");
    });
  }
}