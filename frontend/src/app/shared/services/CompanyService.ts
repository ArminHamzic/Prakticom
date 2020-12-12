import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
<<<<<<< HEAD:frontend/src/app/shared/services/CompanyService.ts
import {environment} from '../../../environments/environment';
import {ICompany} from '../contracts/company';
=======
import {environment} from '../environments/environment';
import {ICompany} from '../app/contracts/company';
import {Observable} from 'rxjs';
>>>>>>> f3e2dd063002416cd8f26086331ee1ad5a5f2d6b:frontend/src/services/CompanyService.ts


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
