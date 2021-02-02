import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {RegisterStudentComponent} from '../register-student.component';
import {ISkill} from '../../../../shared/contracts/skill';
import {StudentService} from '../../../../shared/services/StudentService';
import {IRating} from '../../../../shared/contracts/rating';

@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.sass']
})
export class AddSkillComponent implements OnInit {

  skill: ISkill = {} as ISkill;
  ratings: IRating[] = [];


  constructor(public dialogRef: MatDialogRef<RegisterStudentComponent>,
              public studentService: StudentService) { }

  ngOnInit(): void {
  }

  onClose(): void {
    this.dialogRef.close();
  }

  // @ts-ignore
  async onSubmit(): Promise<ISkill> {
    if (this.skill != null) {
      this.dialogRef.close({data: this.skill});
    }
  }

}
