import { Injectable } from '@angular/core';
import { Livre } from '../model/Livre';

@Injectable({
  providedIn: 'root'
})
export class LivreService {
  livres: Livre[];
  constructor() {
    this.livres = [
      { idLivre: "12e11", titre: "JAVA JEE", genre: "Programation", quantite: 300, auteur: "Phillipe" },
      { idLivre: "17efc110", titre: "Ansible", genre: "Automatisation", quantite: 28, auteur: "Marcel" },
      { idLivre: "103eff1795", titre: "Scrum", genre: "Gestion projet", quantite: 5, auteur: "Ronaldo" },
      { idLivre: "a2e1fc1", titre: "Docker", genre: "Deploiement", quantite: 100, auteur: "Messi" }
    ];
  }
  listeLivres(): Livre[] {
    return this.livres;
  }
  ajouterLivre(livre : Livre){
    this.livres.push(livre);
  }
  supprimerLivre( livre: Livre){
    const index = this.livres.indexOf(livre, 0);
    if (index > -1) {
    this.livres.splice(index, 1);
    }
    }
    consulterLivre(id:string): Livre{
      return this.livres.find(l => l.idLivre == id);
      
      }
      updateLivre(l:Livre){
    // console.log(p);
      this.supprimerLivre(l);
      this.ajouterLivre(l);
      
  }

      
}
