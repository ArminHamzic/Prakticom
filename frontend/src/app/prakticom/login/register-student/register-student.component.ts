import {Component, OnInit, ViewChild} from '@angular/core';
import {IStudent} from '../../../shared/contracts/student';
import {StudentService} from '../../../shared/services/StudentService';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ActivatedRoute, Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {AddSkillComponent} from './add-skill/add-skill.component';
import {ISkill} from '../../../shared/contracts/skill';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {Rating} from '../../../shared/contracts/rating';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.sass']
})
export class RegisterStudentComponent implements OnInit {

  student: IStudent;
  matSkills: MatTableDataSource<ISkill> = new MatTableDataSource<ISkill>();
  displayedColumns: string[] = ['skill', 'rating', 'settings'];
  passwordSafe = '';
  startDate = new Date(2000, 1, 1);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private studentService: StudentService,
              private snackBar: MatSnackBar,
              private router: Router,
              private route: ActivatedRoute,
              public dialog: MatDialog) {
    this.student = {} as IStudent;
    this.matSkills.paginator = this.paginator;
  }

  ngOnInit(): void {
  }

  onClose(): void {
    this.router.navigate(['/home/login']);
  }

  onAddingSkill(): void {
    const dialogRef = this.dialog.open(AddSkillComponent, {autoFocus: true, width: '20%', disableClose: true});
    dialogRef.afterClosed().subscribe(result => {
      this.matSkills.data.push(result.data);
      this.matSkills.data = this.matSkills.data;
    });
  }

  onSubmit(): void {
    if (this.student != null) {
      this.student.skills = this.matSkills.data;
      console.log(this.student);
      this.studentService.save(this.student).subscribe( (response) => {
        this.snackBar.open('Schülerprofil wurde erfolgreich angelegt!', 'X', {
          duration: 8000
        });
        this.router.navigate(['/home/login']);
      });
    }
  }

  onSkillDelete(skill: ISkill): void {
    this.matSkills.data.splice(this.matSkills.data.indexOf(skill), 1);
    this.matSkills.data = this.matSkills.data;
  }

  public get rating(): typeof Rating {
    return Rating;
  }
}
