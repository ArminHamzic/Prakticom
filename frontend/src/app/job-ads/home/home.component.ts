import { Component, OnInit } from '@angular/core';
import {IJob} from '../../contracts/job';
import {JobAdsService} from '../job-ads.service';

@Component({
  selector: 'jobAds-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  jobs: IJob[] = [];
  constructor(private jobService: JobAdsService) {
  }

  async ngOnInit(): Promise<void> {
    this.jobs = await this.jobService.loadJobs();
  }

}
