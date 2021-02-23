import {Component, OnInit, ViewChild} from '@angular/core';
import {ICompany} from '../../../shared/contracts/company';
import {CompanyService} from '../../../shared/services/CompanyService';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {ILocation} from '../../../shared/contracts/location';
import {MatTableDataSource} from '@angular/material/table';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ConfirmValidParentMatcher, CustomValidators, errorMessages, regExps} from '../CustomValidators';

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.sass']
})
export class RegisterCompanyComponent implements OnInit {

  company: ICompany = {} as ICompany;
  location: ILocation = undefined;
  companyLocations: MatTableDataSource<ILocation> = new MatTableDataSource<ILocation>();
  displayedColumns: string[] = ['address', 'city', 'plz', 'country', 'settings'];

  userRegistrationForm: FormGroup;

  confirmValidParentMatcher = new ConfirmValidParentMatcher();

  errors = errorMessages;

  constructor(private companyService: CompanyService,
              private snackBar: MatSnackBar,
              private formBuilder: FormBuilder,
              private router: Router,
              public dialog: MatDialog) {
    this.createForm();
  }

  ngOnInit(): void {
  }

  onClose(): void {
    this.router.navigate(['/home/login']);
  }

  onSubmit(): void {
    if (this.company != null) {
      this.company.locations = this.companyLocations.data;
      this.companyService.save(this.company).subscribe( (response) => {
        this.snackBar.open('Unternehmensprofil wurde erfolgreich angelegt!', 'X', {
          duration: 8000
        });
        this.router.navigate(['/home/login']);
      });
    }
  }

  onAddingLocation(): void {
    if (this.location != null) {
      this.companyLocations.data.push(this.location);
      this.companyLocations.data = this.companyLocations.data;
    }
    this.location = undefined;
  }

  onLocationDelete(element): void {
    this.companyLocations.data.splice(this.companyLocations.data.indexOf(element), 1);
    this.companyLocations.data = this.companyLocations.data;
  }

  onCancel(): void {
    this.location = undefined;
  }

  onNewLocation(): void {
    this.location = {} as ILocation;
  }

  createForm(): void {
    this.userRegistrationForm = this.formBuilder.group({
      passwordGroup: this.formBuilder.group({
        password: ['', [
          Validators.required,
          Validators.pattern(regExps.password)
        ]],
        confirmPassword: ['', Validators.required]
      }, { validator: CustomValidators.childrenEqual})
    });
  }
}
