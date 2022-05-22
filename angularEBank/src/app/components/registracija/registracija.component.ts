import { Component, OnInit } from '@angular/core';
import { RegistracijaService } from 'src/app/service/registracija.service';
import { Router } from '@angular/router';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition }
   from '@angular/material/snack-bar';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {
  constructor(private router: Router, private registracijaService: RegistracijaService, private snackBar: MatSnackBar) { }
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';



  ngOnInit(): void {
  }

  onSubmit() { 
    let ime = (<HTMLInputElement>document.getElementById('ime')).value;
    let prezime = (<HTMLInputElement>document.getElementById('prezime')).value;
    let email = (<HTMLInputElement>document.getElementById('email')).value;
    let adresa = (<HTMLInputElement>document.getElementById('adresa')).value;
    let telefon = (<HTMLInputElement>document.getElementById('telefon')).value;
    let jmbg = (<HTMLInputElement>document.getElementById('jmbg')).value;
    let username = (<HTMLInputElement>document.getElementById('username')).value;
    let password = (<HTMLInputElement>document.getElementById('password')).value;
    // let fizickoLice = (<HTMLInputElement>document.getElementById('fizickoLice')).value;
    let credentials = { ime: ime, prezime: prezime, email: email, adresa: adresa, telefon: telefon, jmbg: jmbg, username: username, password: password};

    if(ime && prezime && email && adresa && telefon && jmbg && username && password) {
      this.registracijaService.registracija(credentials).subscribe(data => 
        { 
          // localStorage.setItem("jwt", data.accessToken);
          this.router.navigateByUrl('/banke');
        },
        error => 
        {
          this.snackBar.open('Losi podaci ', 'Cancel', {
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 10000,
          });
        }
      ); 
    } else {
        this.snackBar.open('Niste uneli sve podatke', 'Cancel', { 
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 10000,
          });
    }
} 

}
