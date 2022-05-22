import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Component({
  selector: 'app-banka',
  templateUrl: './banka.component.html',
  styleUrls: ['./banka.component.css']
})
export class BankaComponent implements OnInit {

  constructor(private http: HttpClient, private sanitizer: DomSanitizer, private snackBar: MatSnackBar) { }
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  public banke: Array<any> = [];
  public banka: any;
  public bankaId: number | any;


  ngOnInit(): void {
    this.getBanke().subscribe(data => {
      this.banke = data;
    })
  }
  getBanke(): Observable<any> {
    return this.http.get<any>("http://localhost:8080/banke",
      // { headers: new HttpHeaders({ "Authorization": "Bearer " + localStorage.getItem("jwt") }) }
    );
  }

  getBankaById() {
    if (this.bankaId) {
      this.http.get<any>("http://localhost:8080/banka/" + this.bankaId,
        // { headers: new HttpHeaders({ "Authorization": "Bearer " + localStorage.getItem("jwt") }) }
      ).subscribe(data => {
        this.banke = [];  // this.message 
        this.banke.push(data);
        (<HTMLInputElement>document.getElementById('clearSearch')).hidden = false;
      }, err => {
        this.snackBar.open(err.error, 'Cancel', {
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
          duration: 10000,
        });   
      })
    }
  }

  getAllBanke() {
    this.bankaId = ''; 
    this.ngOnInit();
    (<HTMLInputElement>document.getElementById('clearSearch')).hidden = true;
  }

  deleteBanka(bankaId: any) {
    if(confirm('Are you sure you want to delete this bank?')) {
      this.http.delete<any>("http://localhost:8080/banka/" + bankaId,
        //{ headers: new HttpHeaders({ "Authorization": "Bearer " + localStorage.getItem("jwt") }) }
        ).subscribe(data => { })
      window.location.reload(); 
      alert('Bank is deleted successfuly.') 
    } 
  }
  hideClearSearchButton() {
    if(this.bankaId == '' || !this.bankaId) {
      (<HTMLInputElement>document.getElementById('clearSearch')).hidden = true;
    } else {
      (<HTMLInputElement>document.getElementById('clearSearch')).hidden = false;
    }
  }

}
