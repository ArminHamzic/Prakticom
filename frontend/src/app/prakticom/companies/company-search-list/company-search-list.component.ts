import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {ICompany} from '../../../shared/contracts/company';
import {CompanyService} from '../../../shared/services/CompanyService';

@Component({
  selector: 'app-company-search-list',
  templateUrl: './company-search-list.component.html',
  styleUrls: ['./company-search-list.component.sass']
})
export class CompanySearchListComponent implements OnInit {

  companies: MatTableDataSource<ICompany>;

  constructor(private companyService: CompanyService) { }

  async ngOnInit(): Promise<void> {
    const rawCompanies = await this.companyService.getAll().toPromise();
    this.companies = new MatTableDataSource<ICompany>(rawCompanies);
    console.log(rawCompanies);
  }

}
