import { Injectable, Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { MatDialog } from '@angular/material/dialog';

@Injectable({
  providedIn: 'root'
})
export class RegistracijaService {

  constructor(private http: HttpClient/*, public dialog: MatDialog*/) { }

  registracija(credentials: any): Observable<any> {
    //alert(credentials.username + ' ' + credentials.password)
    return this.http.post("http://localhost:8080/addKlijent", JSON.stringify(credentials), 
      { headers: new HttpHeaders({ 'Content-Type' : 'application/json'})}
    );
  }

   /*openDialog() {
     this.dialog.open(DialogElementsExampleDialog);
   }*/

}