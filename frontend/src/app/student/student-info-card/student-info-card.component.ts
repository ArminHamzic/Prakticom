import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {StudentService} from '../../../services/StudentService';
import {IStudent} from '../../contracts/student';

@Component({
  selector: 'app-student-info-card',
  templateUrl: './student-info-card.component.html',
  styleUrls: ['./student-info-card.component.css']
})
export class StudentInfoCardComponent implements OnInit {
  students?: IStudent[];
  editStudent?: IStudent;
  deleteStudent?: IStudent;

  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService) { }

  ngOnInit(): void {
  }


}
