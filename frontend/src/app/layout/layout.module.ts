import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import {MaterialModule} from '../material.module';
import { LandingPageComponent } from './landing-page/landing-page.component';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [HeaderComponent, HomeComponent, LandingPageComponent],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule
  ],
  exports: [
    HeaderComponent,
    HomeComponent,
    LandingPageComponent
  ]
})
export class LayoutModule { }
