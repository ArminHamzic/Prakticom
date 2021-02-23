import {Component, Input, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {ICompany} from '../../shared/contracts/company';
import {CompanyService} from '../../shared/services/CompanyService';
import {JobPostingService} from '../../shared/services/JobPostingService';
import {IJobPosting} from '../../shared/contracts/jobPosting';
import {Rating} from '../../shared/contracts/rating';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.sass']
})
export class LandingPageComponent implements OnInit {

  matCompanies: MatTableDataSource<ICompany>;
  matJobPostings: MatTableDataSource<IJobPosting>;
  companies: ICompany[] = [];
  jobPostings: IJobPosting[] = [];
  filteredCompanies: ICompany[] = [];
  searchInput: string;
  searchInput2: string;
  lowerBorderCompanies = 0;
  lowerBorderJobs = 0;
  shownCompanies: ICompany[] = [];
  filteredJobs: IJobPosting[] = [];
  shownJobs: IJobPosting[] = [];


  constructor(private companyService: CompanyService,
              private jobPostingService: JobPostingService) { }

  async ngOnInit(): Promise<void> {
    const rawCompanies = await this.companyService.getAll().toPromise();
    this.companies = rawCompanies;
    this.matCompanies = new MatTableDataSource<ICompany>(rawCompanies);

    const rawJobPostings = await this.jobPostingService.getAll().toPromise();
    this.jobPostings = rawJobPostings;
    this.matJobPostings = new MatTableDataSource<IJobPosting>(rawJobPostings);
    await this.filterJobs();

    // TODO: Ähnlich wie CompanySearchList:25
    /*this.matCompanies.filterPredicate = (data, filter: string)  => {
      const accumulator = (currentTerm, key) => {
        return this.nestedFilterCheck(currentTerm, data, key);
      };
      const dataStr = Object.keys(data).reduce(accumulator, '').toLowerCase();
      // Transform the filter by converting it to lowercase and removing whitespace.
      const transformedFilter = filter.trim().toLowerCase();
      return dataStr.indexOf(transformedFilter) !== -1;
    };*/
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

  async filterJobs(): Promise<void> {
/*    if (this.searchInput !== null || this.searchInput2 !== null) {
      this.matCompanies.filter = this.searchInput.trim().toLowerCase();
      this.matJobPostings.filter = this.searchInput.trim().toLowerCase();
      this.matJobPostings.filter = this.searchInput2.trim().toLowerCase();
      this.matCompanies.filter = this.searchInput2.trim().toLowerCase();
    }*/
    this.filteredCompanies = await this.companyService.getFilteredCompanies(this.searchInput, this.searchInput2).toPromise();
    this.filteredCompanies.forEach(c => {
      this.filteredJobs = [];
      this.jobPostings.forEach(jP => {
        this.filteredJobs.push(jP);
      });
    });
    this.shownCompanies = this.filteredCompanies.slice(this.lowerBorderCompanies, this.lowerBorderCompanies + 4);
    this.shownJobs = this.filteredJobs.slice(this.lowerBorderJobs, this.lowerBorderJobs + 4);

  }

  // tslint:disable-next-line:typedef
  carouselLeftCompany() {
    if (this.lowerBorderCompanies >= 1){
      this.lowerBorderCompanies -= 1;
    }
    this.refreshShownCompanies();
  }
  // tslint:disable-next-line:typedef
  carouselRightCompany() {
    if (this.lowerBorderCompanies + 4 <= this.filteredCompanies.length - 1){
      this.lowerBorderCompanies += 1;
    }
    this.refreshShownCompanies();
  }
  // tslint:disable-next-line:typedef
  carouselLeftJob() {
    if (this.lowerBorderJobs >= 1){
      this.lowerBorderJobs -= 1;
    }
    this.refreshShownJobs();
  }

  // tslint:disable-next-line:typedef
  carouselRightJob() {
    if (this.lowerBorderJobs + 4 <= this.filteredJobs.length - 1){
      this.lowerBorderJobs += 1;
    }
    this.refreshShownJobs();
  }

  private async refreshShownCompanies(): Promise<void> {
    this.companies = await this.companyService.getFilteredCompanies(this.searchInput, this.searchInput2).toPromise();
    this.shownCompanies = this.companies.slice(this.lowerBorderCompanies, this.lowerBorderCompanies + 4);
  }

  private async refreshShownJobs(): Promise<void> {
    this.shownJobs = this.filteredJobs.slice(this.lowerBorderJobs, this.lowerBorderJobs + 4);
  }
}
