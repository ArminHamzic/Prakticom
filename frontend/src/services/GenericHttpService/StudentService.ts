import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService';
import {IStudent} from '../../app/contracts/student';
import {environment} from '../../environments/environment';


@Injectable({
    providedIn: 'root',
})
export class StudentService extends GenericHttpService<IStudent, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/student`);
    }

}