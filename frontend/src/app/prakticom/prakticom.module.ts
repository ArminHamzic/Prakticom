import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentComponent } from './student/student.component';
import { CompaniesComponent } from './companies/companies.component';
import {MaterialModule} from '../material.module';
import { CompanySearchListComponent } from './companies/company-search-list/company-search-list.component';



@NgModule({
  declarations: [StudentComponent, CompaniesComponent, CompanySearchListComponent],
    imports: [
        CommonModule,
        MaterialModule
    ]
})
export class PrakticomModule { }
