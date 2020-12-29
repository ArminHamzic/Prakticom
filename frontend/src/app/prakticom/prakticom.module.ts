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

@NgModule({
  declarations: [StudentComponent, CompaniesComponent, CompanySearchListComponent, CompanyProfilePageComponent,
    CompanyInfoCardComponent, CompanyJobAdsSwiperComponent],
  imports: [
    CommonModule,
    MaterialModule,
    NgxUsefulSwiperModule,
  ]
})
export class PrakticomModule {
}
