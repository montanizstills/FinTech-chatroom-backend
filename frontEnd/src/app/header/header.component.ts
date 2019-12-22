import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(){}
  ngOnInit() {}
  
  // onSubmit(login: NgForm){
  //   create accountObject;
  // }
  username='';
  password='';
  emptyUsername='';
  emptyPassword='';
  signed=false;
  
  alert(message){
    alert(message);
  }
  validate(username:string,password:string){
    this.username=username;
    this.password=password; 
    if(this.emptyUsername!=username&&this.emptyPassword!=password){
        this.signed=true;
      }
     else{
       this.signed=false;}
  }
  login:NgForm;
onSubmit(){
  alert("form submitted");
}
}


//signed=validate()