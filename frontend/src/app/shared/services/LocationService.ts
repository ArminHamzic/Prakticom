import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {ILocation} from '../contracts/location';
import {environment} from '../../../environments/environment';


@Injectable({
    providedIn: 'root',
})
export class LocationService extends GenericHttpService<ILocation, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/location`);
    }

}
