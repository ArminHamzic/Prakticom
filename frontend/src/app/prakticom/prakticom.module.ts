import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StudentComponent} from './student/student.component';
import {CompaniesComponent} from './companies/companies.component';
import {MaterialModule} from '../material.module';
import {CompanySearchListComponent} from './companies/company-search-list/company-search-list.component';
import {CompanyProfilePageComponent} from './companies/company-profile-page/company-profile-page.component';
import {CompanyInfoCardComponent} from './companies/company-profile-page/company-info-card/company-info-card.component';
import {CompanyJobAdsSwiperComponent} from './companies/company-profile-page/company-job-ads-swiper/company-job-ads-swiper.component';
import { NgxUsefulSwiperModule } from 'ngx-useful-swiper';
import {LayoutModule} from '../layout/layout.module';
import {RouterModule} from '@angular/router';
import { CompanyMapComponent } from './companies/company-profile-page/company-map/company-map.component';
import { LoginComponent } from './login/login.component';
import { RegisterStudentComponent } from './login/register-student/register-student.component';
import { RegisterCompanyComponent } from './login/register-company/register-company.component';
import {FormsModule} from "@angular/forms";
import { AddSkillComponent } from './login/register-student/add-skill/add-skill.component';

@NgModule({
  declarations: [StudentComponent, CompaniesComponent, CompanySearchListComponent, CompanyProfilePageComponent,
    CompanyInfoCardComponent, CompanyJobAdsSwiperComponent, CompanyMapComponent, LoginComponent, RegisterStudentComponent, RegisterCompanyComponent, AddSkillComponent],
    imports: [
        CommonModule,
        MaterialModule,
        NgxUsefulSwiperModule,
        LayoutModule,
        RouterModule,
        FormsModule,
    ]
})
export class PrakticomModule {
}
