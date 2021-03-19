import { Component, OnInit } from '@angular/core';
import { Livre } from '../model/Livre';
import { ActivatedRoute, Router } from '@angular/router';
import { LivreService } from '../services/livre.service';


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
              private livreService: LivreService) { }

  ngOnInit(): void {
    // console.log(this.activatedRoute.snapshot.params.id);
    this.currentLivre = this.livreService.consulterLivre(this.activatedRoute.snapshot.params.id);
console.log(this.currentLivre);
  }

  updateLivre(){
    // console.log(this.currentLivre);
    this.livreService.updateLivre(this.currentLivre);
    this.router.navigate(["livres"]);
  }

}
