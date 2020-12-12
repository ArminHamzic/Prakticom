import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
<<<<<<< HEAD:frontend/src/app/shared/services/JobPostingService.ts
import {environment} from '../../../environments/environment';
import {ICompany} from '../contracts/company';
import {IJobPosting} from '../contracts/jobPosting';
=======
import {environment} from '../environments/environment';
import {ICompany} from '../app/contracts/company';
import {IJobPosting} from '../app/contracts/jobPosting';
import {Observable} from 'rxjs';
>>>>>>> f3e2dd063002416cd8f26086331ee1ad5a5f2d6b:frontend/src/services/JobPostingService.ts


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
