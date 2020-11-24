import { Component, OnInit, ViewEncapsulation } from '@angular/core';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'
  ],
  encapsulation: ViewEncapsulation.None
})
export class StudentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
