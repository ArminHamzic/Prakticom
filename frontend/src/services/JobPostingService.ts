import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {environment} from '../environments/environment';
import {ICompany} from '../app/contracts/company';
import {IJobPosting} from '../app/contracts/jobPosting';


@Injectable({
    providedIn: 'root',
})
export class JobPostingService extends GenericHttpService<IJobPosting, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/jobPosting`);
    }

}
