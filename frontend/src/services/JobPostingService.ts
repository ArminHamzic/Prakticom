import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {environment} from '../environments/environment';
import {ICompany} from '../app/contracts/company';
import {IJobPosting} from '../app/contracts/jobPosting';
import {Observable} from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class JobPostingService extends GenericHttpService<IJobPosting, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/jobPosting`);
    }

    getByCompanyId(companyId: number): Observable<IJobPosting> {
        return this.http.get<IJobPosting>(this.base + '/company/' + companyId);
    }

    // TODO: JobPosting POST
}
