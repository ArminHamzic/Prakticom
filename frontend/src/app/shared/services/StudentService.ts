import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {IStudent} from '../contracts/student';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Rating} from '../contracts/rating';


@Injectable({
    providedIn: 'root',
})
export class StudentService extends GenericHttpService<IStudent, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/student`);
    }

    save(t: IStudent): Observable<IStudent> {

      const skills: NewSkill[] = [];
      interface NewSkill{
        id: number;
        name: string;
        rating: string;
      }

      t.skills.forEach(s => {
        const newSkill: NewSkill = {id: s.id, name: s.name, rating: Rating[s.rating]};
        skills.push(newSkill);
      });
      t.skills = skills;
      return super.save(t);
    }
}
