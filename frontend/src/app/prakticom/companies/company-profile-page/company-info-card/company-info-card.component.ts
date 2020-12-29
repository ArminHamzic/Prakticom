import { Component, OnInit } from '@angular/core';
import {ICompany} from '../../../../shared/contracts/company';
import {ActivatedRoute, Router} from '@angular/router';
import {CompanyService} from '../../../../shared/services/CompanyService';

@Component({
  selector: 'app-company-info-card',
  templateUrl: './company-info-card.component.html',
  styleUrls: ['./company-info-card.component.sass']
})
export class CompanyInfoCardComponent implements OnInit {

  companies: ICompany[];
  company: ICompany;

  constructor(private route: ActivatedRoute, private router: Router, private companyApiService: CompanyService) { }

  async ngOnInit(): Promise<void> {
    await this.onLoadCompanies();
    this.company = await this.getFirstCompany();
    console.log('test');
    console.log(this.company);
  }

  async onLoadCompanies(): Promise<void> {
    this.companies = await this.companyApiService.getAll().toPromise();
    console.log(this.companies);
  }

  async getFirstCompany(): Promise<ICompany> {
    return this.companies.shift();
  }
}
