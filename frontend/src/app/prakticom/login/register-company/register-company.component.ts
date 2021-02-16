import { Component, OnInit } from '@angular/core';
import {FormControl, Validators, ReactiveFormsModule} from '@angular/forms';
import {getErrorMessage} from 'codelyzer/templateAccessibilityElementsContentRule';
import {FieldOfWork, IJobPosting} from '../../../shared/contracts/jobPosting';
import {ICompany} from '../../../shared/contracts/company';
import {CompanyService} from '../../../shared/services/CompanyService';
import {ILocation} from '../../../shared/contracts/location';
import {IStudent} from "../../../shared/contracts/student";
import {StudentService} from "../../../shared/services/StudentService";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {AddSkillComponent} from "../register-student/add-skill/add-skill.component";

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.sass']
})
export class RegisterCompanyComponent implements OnInit {

  company: ICompany = {} as ICompany;
  passwordSafe = '';

  constructor(private companyService: CompanyService,
              private snackBar: MatSnackBar,
              private router: Router,
              public dialog: MatDialog) { }

  /*
  async onSubmit(): Promise<void> {
    if (this.employee != null) {
      await this.employeeService.createUser({body: this.employee}).subscribe(  (response) => {
        this.snackBar.open('Mitarbeiter wurde erfolgreich angelegt!', 'X', {
          duration: 8000
        });
        this.navigation.back();
      });
    }
  }
   */


  ngOnInit(): void {
    this.companyService.getAll();
  }

  onClose(): void {
    this.router.navigate(['/home/login']);
  }

  onSubmit(): void {}
}
