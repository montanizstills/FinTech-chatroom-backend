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
  
  onSubmit(login: NgForm){
    alert("hi");
  }
  emptyUsername='';
  emptyPassword='';
  changeStyle(){
    alert("wassup");
  }
  validate(username:string,password:string){
     if(this.emptyUsername==username||this.emptyPassword==password){
       this.changeStyle()
     }
     else alert("bye");
  } 

  /*if username && password valid
-- > host:.signInButton{
      border:transparent;
      border-radius:30px;
      background-color:green;
    }
*/  


}
