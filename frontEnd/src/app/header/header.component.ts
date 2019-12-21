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
  
  emptyUsername='';
  emptyPassword='';
  signed=false;
 
  validate(username:string,password:string){
     if(this.emptyUsername!=username&&this.emptyPassword!=password){
        this.signed=true;
     }
     else{this.signed=false;}
  }
  reset(){
    
  } 

}
