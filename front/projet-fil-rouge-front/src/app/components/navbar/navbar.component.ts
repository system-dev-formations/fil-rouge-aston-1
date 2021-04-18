import { Component } from '@angular/core';
import { Location } from '@angular/common';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavBarComponent {

  public selectedVal: string;

  constructor() {

  }

  ngOnInit(){

    var uri: String = window.location.href.split('/').pop();

    if(uri == '') {
        this.selectedVal ='accueil';
    }
    if(uri == 'livres') {
        this.selectedVal ='livres';
    }
    if(uri == 'reservations') {
        this.selectedVal ='reservations';
    }
  }

  public onValChange(val: string) {
    this.selectedVal = val;
  }
}
