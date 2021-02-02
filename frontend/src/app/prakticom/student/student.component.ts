import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CompanyService} from '../../shared/services/CompanyService';
import {ICompany} from '../../shared/contracts/company';
import {IStudent} from '../../shared/contracts/student';
import {StudentService} from '../../shared/services/StudentService';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.sass']
})
export class StudentComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private studentService: StudentService) { }

  studentId: number;
  student: IStudent;

  async ngOnInit(): Promise<void> {
    this.studentId = +this.activatedRoute.snapshot.paramMap.get('id');
    this.student = await this.studentService.get(this.studentId).toPromise();
  }

  openTab(pdf: string): void {
    window.open(pdf, '_blank');
  }
}


//region Code für Changing Student
/*import { Component, OnInit } from '@angular/core';
import { StudentService} from '../../shared/services/StudentService';
import {IStudent} from '../../shared/contracts/student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.sass']
})
export class StudentComponent implements OnInit {

  constructor() {
  }


  ngOnInit(): void {

  }

  //region Code für Eingabe von Skills

  // skills: string[] = ['Angular'];
  onClick(skill: string): void{
    const index = this.skills.indexOf(skill);
    if (index > -1) {
      this.skills.splice(index, 1);
    }
  }

  onEnter(input: any): void {
    if (input !== '') {
      this.skills.push(input.value);
    }
    input.value = '';
  }
  //endregion
}*/
//endregion

