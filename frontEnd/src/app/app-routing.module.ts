import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AppComponent } from './app.component';




const routes: Routes = [
    {
      path:'',
      component: AppComponent
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
