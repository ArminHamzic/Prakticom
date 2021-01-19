import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CompanyService} from '../../../shared/services/CompanyService';
import {ICompany} from '../../../shared/contracts/company';

@Component({
  selector: 'app-company-profile-page',
  templateUrl: './company-profile-page.component.html',
  styleUrls: ['./company-profile-page.component.sass']
})
export class CompanyProfilePageComponent implements OnInit {

  company: ICompany;
  constructor(private route: ActivatedRoute, private router: Router, private companyService: CompanyService) {}

  async ngOnInit(): Promise<void> {
    const companyId = this.route.snapshot.paramMap.get('id');
    this.company = await this.companyService.get(Number(companyId)).toPromise();
  }

}
