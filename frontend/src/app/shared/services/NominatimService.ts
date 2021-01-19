import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {INominatimResponse} from '../contracts/nominatimResponse';
const BASE_NOMINATIM_URL = 'nominatim.openstreetmap.org';
const DEFAULT_VIEW_BOX = 'viewbox=-25.0000%2C70.0000%2C50.0000%2C40.0000';

@Injectable({
  providedIn: 'root',
})
export class NominatimService {

  constructor(private http: HttpClient) {
  }

  addressLookup(address: string): void {
    this.http.get('https://nominatim.openstreetmap.org/search?format=json&q=' + address)
      .subscribe(
        (res: Response) =>
        {
          const searchResult = res.json();
          console.log(searchResult);
        }
      );
  }

}
