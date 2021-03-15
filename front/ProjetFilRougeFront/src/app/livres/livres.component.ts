import { Component, OnInit } from '@angular/core';
import { Livre } from '../model/Livre';
import { LivreService } from '../services/livre.service';

@Component({
  selector: 'app-livres',
  templateUrl: './livres.component.html',
  styleUrls: ['./livres.component.css']
})
export class LivresComponent implements OnInit {

  livres: Livre[];
  constructor(private livreService: LivreService) {
    this.livres = livreService.listeLivres();
  }

  ngOnInit(): void {
  }

}
