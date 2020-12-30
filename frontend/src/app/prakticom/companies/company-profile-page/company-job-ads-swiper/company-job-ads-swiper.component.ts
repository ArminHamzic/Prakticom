import { Component, OnInit } from '@angular/core';
import Swiper from 'swiper';
import {CompanyService} from '../../../../shared/services/CompanyService';
import {ICompany} from '../../../../shared/contracts/company';

@Component({
  selector: 'app-company-job-ads-swiper',
  templateUrl: './company-job-ads-swiper.component.html',
  styleUrls: ['./company-job-ads-swiper.component.sass']
})
export class CompanyJobAdsSwiperComponent implements OnInit {
  companies: ICompany[];

  constructor(private companyService: CompanyService) { }

  async ngOnInit(): Promise<void> {
    this.companies = await this.companyService.getAll().toPromise();
    const swiper = new Swiper('.swiper-container', {
      slidesPerView: 3,
      spaceBetween: 30,
      slidesPerGroup: 1,
      loop: true,
      loopFillGroupWithBlank: true,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  }

}
