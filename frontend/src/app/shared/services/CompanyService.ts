import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {ICompany} from '../contracts/company';
import {Observable} from 'rxjs';
import {environment} from '../../../../../../../Desktop/frontend/src/environments/environment';


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
