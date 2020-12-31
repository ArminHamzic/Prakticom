import {AfterViewInit, Component, Injectable, OnInit} from '@angular/core';


declare var ol: any;

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.sass']
})
export class MapComponent implements AfterViewInit{
  map: any;

  latitude = 48.30639;
  longitude = 14.28611;

  iconFeature = new ol.Feature({
    geometry: new ol.geom.Point(ol.proj.fromLonLat([-2, 53])),
    name: 'Somewhere near Nottingham',
  });

  constructor() {
  }

  ngAfterViewInit(): void {
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
        center: ol.proj.fromLonLat([-2, 53]),
        zoom: 6
      })
    });
  }
}
