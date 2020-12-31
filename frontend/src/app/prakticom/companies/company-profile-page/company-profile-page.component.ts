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

  ngOnInit(): void {
  }

}
