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

  skills: string[] = ['Angular' ,'', 'Quarkus', '', 'Java', '', 'C#'];

}
