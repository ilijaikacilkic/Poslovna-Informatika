import { Component, OnInit } from '@angular/core';
import { Router }from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
  }

  //vrsi rutiranje na login
  redirectToLogin(){
    this.route.navigate(['login']);
  }

  redirectToRegistracija(){
    this.route.navigate(['registracija']);
  }

}
