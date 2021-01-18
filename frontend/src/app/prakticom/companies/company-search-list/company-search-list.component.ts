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

  companies: MatTableDataSource<ICompany>;
  constructor(private companyService: CompanyService) { }

  async ngOnInit(): Promise<void> {
    const rawCompanies = await this.companyService.getAll().toPromise();


    // @ts-ignore
    this.companies = new MatTableDataSource<ICompany>(rawCompanies);
    console.log(this.companies);
    this.companies.filterPredicate = (data, filter: string)  => {
      const accumulator = (currentTerm, key) => {
        return this.nestedFilterCheck(currentTerm, data, key);
      };
      const dataStr = Object.keys(data).reduce(accumulator, '').toLowerCase();
      // Transform the filter by converting it to lowercase and removing whitespace.
      const transformedFilter = filter.trim().toLowerCase();
      return dataStr.indexOf(transformedFilter) !== -1;
    };
  }

  // tslint:disable-next-line:typedef
  nestedFilterCheck(search, data, key) {
    if (typeof data[key] === 'object') {
      for (const k in data[key]) {
        if (data[key][k] !== null) {
          search = this.nestedFilterCheck(search, data[key], k);
        }
      }
    } else {
      search += data[key];
    }
    return search;
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.companies.filter = filterValue.trim().toLowerCase();
  }

}
