<<<<<<< HEAD
import { Component, OnInit } from '@angular/core';
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
  /*onClick(skill: string): void{
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
  }*/
  //endregion
}
=======
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.sass']
})
export class StudentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  skills: string[] = ['Angular', 'Quarkus', '', 'Java', '', 'C#'];

}
>>>>>>> e2b38ba04a78284544cce49db07cdfa7b7abec78
