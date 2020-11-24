import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobAdsRoutingModule } from './job-ads-routing.module';
import { HomeComponent } from './home/home.component';
import { CardComponent } from './card/card.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import {FormsModule} from '@angular/forms';


@NgModule({
    declarations: [HomeComponent, CardComponent, JobDetailsComponent],
    exports: [
        HomeComponent
    ],
    imports: [
        CommonModule,
        JobAdsRoutingModule,
        FormsModule
    ]
})
export class JobAdsModule { }
