import { Component, OnInit } from '@angular/core';
import Swiper from 'swiper';

@Component({
  selector: 'app-company-job-ads-swiper',
  templateUrl: './company-job-ads-swiper.component.html',
  styleUrls: ['./company-job-ads-swiper.component.sass']
})
export class CompanyJobAdsSwiperComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
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
