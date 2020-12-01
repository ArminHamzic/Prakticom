import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {WelcomeComponent} from './welcome/welcome.component';
import {FooterComponent} from './welcome/footer/footer.component';
import {CardComponent} from './welcome/card/card.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {JobAdsModule} from './job-ads/job-ads.module';
import {HttpClientModule} from '@angular/common/http';
import {StudentComponent} from './student/student.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ReactiveFormsModule} from '@angular/forms';
import {CompanyComponent} from './company/company.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { StudentInfoCardComponent } from './student/student-info-card/student-info-card.component';
import { StudentCompetenciesComponent } from './student/student-competencies/student-competencies.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import {MaterialModule} from './material.module';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    FooterComponent,
    CardComponent,
    MaterialModule,
    NotFoundComponent,
    StudentComponent,
    CompanyComponent,
    StudentInfoCardComponent,
    StudentCompetenciesComponent,
    MainNavComponent,
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    JobAdsModule,
    NgbModule,
    ReactiveFormsModule,
    LayoutModule,
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule {
}
