import { Component, OnInit } from '@angular/core';
import {IStudent} from '../../../shared/contracts/student';
import {StudentService} from '../../../shared/services/StudentService';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.sass']
})
export class RegisterStudentComponent implements OnInit {

  constructor(private studentService: StudentService,
              private snackBar: MatSnackBar,
              private router: Router) { }

  student: IStudent;

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
  employee: any; // TODO: Property 'employee' does not exist on type 'RegisterStudentComponent' : register-student.component.html:34:135


  ngOnInit(): void {
    this.studentService.getAll();
  }

  onClose(): void {
    this.router.navigate(['/home/login']);
  }

  onSubmit(): void {
    // TODO: Property 'onSubmit' does not exist on type 'RegisterStudentComponent' : register-student.component.html:40:124
  }
}
