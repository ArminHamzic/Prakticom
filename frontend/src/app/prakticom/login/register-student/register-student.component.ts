import { Component, OnInit } from '@angular/core';
import {IStudent} from '../../../shared/contracts/student';
import {StudentService} from '../../../shared/services/StudentService';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {AddSkillComponent} from './add-skill/add-skill.component';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.sass']
})
export class RegisterStudentComponent implements OnInit {

  student: IStudent = {} as IStudent;
  displayedColumns: string[] = ['skill', 'rating', 'settings'];
  passwordSafe = '';
  startDate = new Date(1995, 1, 1);

  constructor(private studentService: StudentService,
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
    this.studentService.getAll();
  }

  onClose(): void {
    this.router.navigate(['/home/login']);
  }

  onAddingSkill(): void {
    const dialogRef = this.dialog.open(AddSkillComponent, {autoFocus: true, width: '20%', disableClose: true});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result.data);
      this.student.skills?.push(result.data);
      console.log(this.student.skills);
    });
  }

  onSubmit(): void {}

  // tslint:disable-next-line:typedef
  onSkillDelete(id) {

  }

  // tslint:disable-next-line:typedef
  onSkillEdit(element) {

  }
}
