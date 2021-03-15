import { Component, OnInit } from '@angular/core';
import { Livre } from '../model/Livre';
import { LivreService } from '../services/livre.service';

@Component({
  selector: 'app-ajouter-livre',
  templateUrl: './ajouter-livre.component.html',
  styleUrls: ['./ajouter-livre.component.css']
})
export class AjouterLivreComponent implements OnInit {
  newLivre = new Livre();

  message :string;
  constructor(private livreService: LivreService) { }

  ngOnInit(): void {
  }

  addLivre() {
    // console.log(this.newLivre);
    this.livreService.ajouterLivre(this.newLivre);
    this.message = "Livre " + this.newLivre.titre + " ajouté avec succés ! "

  }

}
