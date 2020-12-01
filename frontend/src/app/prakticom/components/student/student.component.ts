import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {StudentService} from '../../../shared/services/StudentService';
import {IStudent} from '../../../shared/contracts/student';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'
  ],
  encapsulation: ViewEncapsulation.None
})
export class StudentComponent implements OnInit {


  constructor(public studentService: StudentService) { }

  ngOnInit(): void {
  }

}
