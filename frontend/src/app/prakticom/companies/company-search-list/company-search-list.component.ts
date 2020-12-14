import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {ICompany} from '../../../shared/contracts/company';
import {CompanyService} from '../../../shared/services/CompanyService';
import {LinkedList} from '@angular-devkit/schematics/src/utility/linked-list';

@Component({
  selector: 'app-company-search-list',
  templateUrl: './company-search-list.component.html',
  styleUrls: ['./company-search-list.component.sass']
})
export class CompanySearchListComponent implements OnInit {

  // @ts-ignore
  companies: LinkedList<ICompany>;
  constructor(private companyService: CompanyService) { }

  // tslint:disable-next-line:typedef
  async ngOnInit() {
    const rawCompanies = await this.companyService.getAll().toPromise();
    // @ts-ignore
    this.companies = rawCompanies;
    console.log(rawCompanies);
  }

}
