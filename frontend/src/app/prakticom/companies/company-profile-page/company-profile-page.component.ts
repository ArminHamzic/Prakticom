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

  constructor(private route: ActivatedRoute, private router: Router, private companyApiservice: CompanyService) { }

  ngOnInit(): void {
    this.onLoadCompany(1);
  }

  async onLoadCompany(id: number): Promise<void> {
    this.company = await this.companyApiservice.get(id).toPromise();
    console.log(this.company);
  }


}
