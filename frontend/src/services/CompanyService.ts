import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {environment} from '../environments/environment';
import {ICompany} from '../app/contracts/company';
import {Observable} from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class CompanyService extends GenericHttpService<ICompany, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/company`);
    }

    getByEmail(url: string): Observable<ICompany> {
        return this.http.get<ICompany>(this.base + '/url/' + url);
    }

}
