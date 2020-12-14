import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentComponent } from './student/student.component';
import { CompaniesComponent } from './companies/companies.component';



@NgModule({
  declarations: [StudentComponent, CompaniesComponent],
  imports: [
    CommonModule
  ]
})
export class PrakticomModule { }
