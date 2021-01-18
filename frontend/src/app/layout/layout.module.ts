import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import {RouterModule} from '@angular/router';
import {MaterialModule} from '../material.module';
import { InfoCardComponent } from './info-card/info-card.component';
import { CardComponent } from './card/card.component';

@NgModule({
    declarations: [HeaderComponent, HomeComponent, LandingPageComponent, InfoCardComponent, CardComponent],
    exports: [
        CardComponent
    ],
    imports: [
        CommonModule,
        RouterModule,
        MaterialModule
    ]
})
export class LayoutModule { }
