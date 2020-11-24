import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {WelcomeComponent} from './welcome/welcome.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {StudentComponent} from './student/student.component';
import {CompanyComponent} from './company/company.component';


const routes: Routes = [
  {path: 'jobs', loadChildren: () => import('./job-ads/job-ads.module').then((m) => m.JobAdsModule)},
  {path: 'student', component: StudentComponent},
  {path: 'company', component: CompanyComponent},
  {path: '', component: WelcomeComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
