import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {getErrorMessage} from 'codelyzer/templateAccessibilityElementsContentRule';
import {FieldOfWork, IJobPosting} from '../../../shared/contracts/jobPosting';
import {ICompany} from '../../../shared/contracts/company';
import {CompanyService} from '../../../shared/services/CompanyService';
import {ILocation} from '../../../shared/contracts/location';

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.sass']
})
export class RegisterCompanyComponent implements OnInit {

  hide = true;
  email = new FormControl('', [Validators.required, Validators.email]);
  workingField = new FormControl();
  workingFields: string[] = [];
  company: ICompany;
  companyName: any;
  contactName: any;
  contactEmail: any;
  phoneNumber: any;
  description: any;
  selectedWorkingFields: any;
  mainAddress: any;
  city: any;
  postCode: any;
  location: ILocation;

  constructor(private companyService: CompanyService) { }

  ngOnInit(): void {
    this.workingFields = Object.keys(FieldOfWork).filter(o => isNaN(o as any));
  }
  getErrorMessage(): string {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  onRegisterButtonClicked(): void {
    this.location.streetName = this.mainAddress;
    this.location.city = this.city;
  }
}
