import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './layout/home/home.component';
import {LandingPageComponent} from './layout/landing-page/landing-page.component';
import {StudentComponent} from './prakticom/student/student.component';
import {CompaniesComponent} from './prakticom/companies/companies.component';
import {CompanyProfilePageComponent} from './prakticom/companies/company-profile-page/company-profile-page.component';
import {LoginComponent} from './prakticom/login/login.component';

const routes: Routes = [
  {path: '', redirectTo: 'home/landing-page', pathMatch: 'full'},
  {path: 'home', component: HomeComponent, children: [
      {path: '', component: LandingPageComponent},
      {path: 'landing-page', component: LandingPageComponent},
      {path: 'login', component: LoginComponent},
      {path: 'companies', component: CompaniesComponent},
      {path: 'company/:id', component: CompanyProfilePageComponent},
      {path: 'student/:id', component: StudentComponent}],
    },
  {path: '**', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
