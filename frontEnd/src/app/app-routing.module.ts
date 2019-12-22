import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {HomeComponent} from './home/home.component';
import { AppComponent } from './app.component';




const routes: Routes = [
    // {
    //   path:'',
    //   component:AppComponent
    // }, makes two AppComponents, want to redirect to 
    // localhost:4200/
    {
      path:'home',
      component: HomeComponent
    },
    {
    path:'contact',
    component: ContactUsComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
