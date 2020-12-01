import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {environment} from '../../../environments/environment';
import {ICompany} from '../contracts/company';


@Injectable({
    providedIn: 'root',
})
export class CompanyService extends GenericHttpService<ICompany, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/company`);
    }

}
