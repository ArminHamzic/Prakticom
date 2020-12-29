import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyJobAdsSwiperComponent } from './company-job-ads-swiper.component';

describe('CompanyJobAdsSwiperComponent', () => {
  let component: CompanyJobAdsSwiperComponent;
  let fixture: ComponentFixture<CompanyJobAdsSwiperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyJobAdsSwiperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyJobAdsSwiperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
