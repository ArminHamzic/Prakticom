import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.sass']
})
export class StudentComponent implements OnInit {

  constructor() { }

  skills: string[] = ['Angular', 'Quarkus', '', 'Java', '', 'C#'];

  ngOnInit(): void {
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

