import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import {GenericHttpService} from './GenericHttpService/GenericHttpService';
import {environment} from '../environments/environment';
import {ILocation} from '../app/contracts/location';


@Injectable({
    providedIn: 'root',
})
export class LocationService extends GenericHttpService<ILocation, number> {

    constructor(protected http: HttpClient) {
        super(http, `${environment.api.baseUrl}/location`);
    }

}
