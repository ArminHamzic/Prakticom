import {Component, Input, OnInit} from '@angular/core';
import Swiper from 'swiper';
import {CompanyService} from '../../../../shared/services/CompanyService';
import {ICompany} from '../../../../shared/contracts/company';
import {MatTableDataSource} from '@angular/material/table';
import {IJobPosting} from '../../../../shared/contracts/jobPosting';
import {JobPostingService} from '../../../../shared/services/JobPostingService';

@Component({
  selector: 'app-company-job-ads-swiper',
  templateUrl: './company-job-ads-swiper.component.html',
  styleUrls: ['./company-job-ads-swiper.component.sass']
})
export class CompanyJobAdsSwiperComponent implements OnInit {
  @Input() company: ICompany;
  jobPostings: IJobPosting[] = [];
  lowerBorder = 0;
  shownJobPostings: IJobPosting[] = [];


  constructor(private companyService: CompanyService, private jobPostingService: JobPostingService) { }

  async ngOnInit(): Promise<void> {
    const rawJobPostings = await this.jobPostingService.getAll().toPromise();
    this.jobPostings = rawJobPostings;

    this.shownJobPostings = this.jobPostings.slice(this.lowerBorder, this.lowerBorder + 4);
    console.log(this.shownJobPostings);
  }
  carouselLeft(): void {
    if (this.lowerBorder >= 1){
      this.lowerBorder -= 1;
    }
    this.refreshShownJobPostings();
  }
  carouselRight(): void {
    if (this.lowerBorder + 4 <= this.shownJobPostings.length - 1){
      this.lowerBorder += 1;
    }
    this.refreshShownJobPostings();
  }
  private async refreshShownJobPostings(): Promise<void> {
    this.shownJobPostings = this.jobPostings.slice(this.lowerBorder, this.lowerBorder + 4);
  }

}
