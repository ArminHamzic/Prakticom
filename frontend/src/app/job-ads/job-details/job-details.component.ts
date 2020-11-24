import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IJob} from '../../contracts/job';
import {JobAdsService} from '../job-ads.service';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {
  // @ts-ignore
  id: number;
  // @ts-ignore
  job: IJob;
  email = 'human-resources@';

  constructor(private route: ActivatedRoute, private router: Router, private jobService: JobAdsService) {
  }

  async ngOnInit(): Promise<void> {
    /*this.route.paramMap.subscribe(map => this.id = parseInt(map.get('id'), 10));
    this.job = await this.jobService.loadJob(this.id);
    console.log(this.job.title);
    this.email += this.job.website;*/
  }
}
