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

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private companyService: CompanyService) {}
  company: ICompany;
  async ngOnInit(): Promise<void> {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    this.company = await this.companyService.get(parseInt(id, 10)).toPromise();
  }

}
