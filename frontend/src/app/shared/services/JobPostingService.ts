import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {IJobPosting} from '../contracts/jobPosting';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {ICompany} from '../contracts/company';


@Injectable({
    providedIn: 'root',
})
export class JobPostingService extends GenericHttpService<IJobPosting, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/jobPosting`);
    }

    getByCompanyId(id: number): Observable<IJobPosting[]> {
      return this.http.get<IJobPosting[]>(this.base + '/company/' + id);
    }
}
