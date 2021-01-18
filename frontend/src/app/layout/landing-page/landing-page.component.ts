import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {ICompany} from '../../shared/contracts/company';
import {CompanyService} from '../../shared/services/CompanyService';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.sass']
})
export class LandingPageComponent implements OnInit {

  matCompanies: MatTableDataSource<ICompany>;
  companies: ICompany[] = [];

  constructor(private companyService: CompanyService) { }

  async ngOnInit(): Promise<void> {
    const rawCompanies = await this.companyService.getAll().toPromise();
    this.companies = rawCompanies;
    this.matCompanies = new MatTableDataSource<ICompany>(rawCompanies);
    console.log(this.companies);
    this.matCompanies.filterPredicate = (data, filter: string)  => {
      const accumulator = (currentTerm, key) => {
        return this.nestedFilterCheck(currentTerm, data, key);
      };
      const dataStr = Object.keys(data).reduce(accumulator, '').toLowerCase();
      // Transform the filter by converting it to lowercase and removing whitespace.
      const transformedFilter = filter.trim().toLowerCase();
      return dataStr.indexOf(transformedFilter) !== -1;
    };
  }

  transform(items: any[], filterQuery: any): any[] {
    if (!filterQuery) {
      return items;
    }
    return items.filter(item => item.whateverProperty.toLowerCase().includes(filterQuery.toLowerCase()));
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
    this.matCompanies.filter = filterValue.trim().toLowerCase();
  }

}
