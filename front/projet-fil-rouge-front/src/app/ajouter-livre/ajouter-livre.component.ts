import { Component, OnInit } from '@angular/core';
import { Livre } from '../model/Livre';
import { LivreService } from '../services/livre.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-ajouter-livre',
  templateUrl: './ajouter-livre.component.html',
  styleUrls: ['./ajouter-livre.component.css'],
  
})
export class AjouterLivreComponent implements OnInit {
  newLivre = new Livre();

  message :string;
  constructor(private livreService: LivreService,
  private router : Router) { }

  ngOnInit(): void {
  }

  // addLivre() {
  //   // console.log(this.newLivre);
  //   this.livreService.ajouterLivre(this.newLivre);
  //   this.message = "Livre " + this.newLivre.titre + " ajouté avec succés ! "

  // }
  addLivre(){
    this.livreService.ajouterLivre(this.newLivre)
    .subscribe(livre => {
    console.log(livre);
    });
    this.router.navigate(['livres']).then(() => {
window.location.reload();
});
    }

}
