import { Component, OnInit } from '@angular/core';
import {IStudent} from "../../../shared/contracts/student";
import {StudentService} from "../../../shared/services/StudentService";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.sass']
})
export class RegisterStudentComponent implements OnInit {

  student: IStudent;

  constructor(private studentService: StudentService,
              private snackBar: MatSnackBar,
              private router: Router) { }


  ngOnInit(): void {
    this.studentService.getAll();
  }

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

  onClose(): void {
    this.router.navigate(['/home/login']);
  }

}
