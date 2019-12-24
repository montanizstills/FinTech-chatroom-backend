import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {HomeComponent} from './home/home.component';
import { PrefixNot } from '@angular/compiler';
//import { AppComponent } from './app.component';

const routes: Routes = [
    {
      path:'',
      redirectTo: 'home',
      pathMatch: 'full'
//    pathMatch: 'prefix'
    },
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
