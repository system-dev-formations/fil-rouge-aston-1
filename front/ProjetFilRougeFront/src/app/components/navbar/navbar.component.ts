import { Component } from '@angular/core';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavBarComponent {

  public selectedVal: string;

  constructor() { }

  ngOnInit(){
    this.selectedVal ='accueil';
  }

  public onValChange(val: string) {
    this.selectedVal = val;
  }
}
