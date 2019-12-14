import { Component, OnInit } from '@angular/core';
import {Account} from '../account';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(){}
  ngOnInit() {}
  

   //form:HTMLElement  = document.getElementById("form");
   
  submit():void{
    alert("submit function working.");
  }
  //username:String=document.getElementById("username").value;

  

}
