import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {INominatimResponse} from '../../../../shared/contracts/nominatimResponse';
import {ICompany} from '../../../../shared/contracts/company';
import {NominatimService} from '../../../../shared/services/NominatimService';
import {ActivatedRoute, Router} from '@angular/router';
import * as Nominatim from 'nominatim-browser';
import {NominatimResponse} from 'nominatim-browser';

declare var ol: any;

@Component({
  selector: 'app-company-map',
  templateUrl: './company-map.component.html',
  styleUrls: ['./company-map.component.sass']
})

export class CompanyMapComponent implements AfterViewInit {

  map: any;
  searchResults: INominatimResponse[];
  address = '';

  @Input() company: ICompany;

  latitude = 48.30639;
  longitude = 14.28611;

  iconFeature = new ol.Feature({
    geometry: new ol.geom.Point(ol.proj.fromLonLat([this.longitude, this.latitude])),
  });

  constructor(private route: ActivatedRoute, private router: Router, private nominatimService: NominatimService) {
  }

  ngAfterViewInit(): void {
    this.address = this.company.locations.shift().streetName;
    console.log(this.address);
    console.log(this.searchResults);

    console.log( 'test123412' + this.address);

    Nominatim.geocode({
      street: this.address,
      addressdetails: true,
    })
      .then((results: NominatimResponse[]) =>
      {
        const result = results[0];
        this.longitude = Number(result.lon);
        this.latitude = Number(result.lat);

        console.log(result.lat);          // '44.9772995'
        console.log(result.lon);          // '-93.2654691'
        console.log(result.display_name); // 'Minneapolis, Hennepin County, Minnesota, United States of America'

        // result.address is only returned when 'addressdetails: true' is sent in the geocode request
        console.log(result.address.city);    // 'Minneapolis'
        console.log(result.address.county);  // 'Hennepin County'
        console.log(result.address.state);   // 'Minnesota'
        console.log(result.address.country); // 'United States of America'

      })
      .catch((error) =>
      {
        console.error(error);
      });
    /*this.map = new ol.Map({
      target: 'map',
      layers: [
        new ol.layer.Tile({
          source: new ol.source.OSM(),
        }),
      ],
      view: new ol.View({
        center: ol.proj.fromLonLat([this.longitude, this.latitude]),
        zoom: 10,
      }),
    });*/
    this.map = new ol.Map({
      target: 'map',
      layers: [
        new ol.layer.Tile({
          source: new ol.source.OSM(),
        }),
        new ol.layer.Vector({
          source: new ol.source.Vector({
            features: [this.iconFeature]
          }),
          style: new ol.style.Style({
            image: new ol.style.Icon({
              anchor: [0.5, 46],
              anchorXUnits: 'fraction',
              anchorYUnits: 'pixels',
              src: 'https://openlayers.org/en/latest/examples/data/icon.png'
            })
          })
        })
      ],
      view: new ol.View({
        center: ol.proj.fromLonLat([this.longitude, this.latitude]),
        zoom: 14
      })
    });
  }
}
