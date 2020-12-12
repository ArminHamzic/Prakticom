import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './layout/home/home.component';
import {LandingPageComponent} from './layout/landing-page/landing-page.component';

const routes: Routes = [
  {path: '', redirectTo: 'home/landing-page', pathMatch: 'full'},
  {path: 'home', component: HomeComponent, children: [
      {path: '', component: LandingPageComponent},
      {path: 'landing-page', component: LandingPageComponent}],
    },
  {path: '**', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
