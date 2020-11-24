import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {WelcomeComponent} from './welcome/welcome.component';
import {NavbarComponent} from './welcome/navbar/navbar.component';
import {FooterComponent} from './welcome/footer/footer.component';
import {CardComponent} from './welcome/card/card.component';
import {MatIconModule} from '@angular/material/icon';
import {NotFoundComponent} from './not-found/not-found.component';
import {JobAdsModule} from './job-ads/job-ads.module';
import {HttpClientModule} from '@angular/common/http';
import {StudentComponent} from './student/student.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatTabsModule} from '@angular/material/tabs';
import {CompanyComponent} from './company/company.component';
import {MatListModule} from '@angular/material/list';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { StudentInfoCardComponent } from './student/student-info-card/student-info-card.component';
import { StudentCompetenciesComponent } from './student/student-competencies/student-competencies.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { LayoutModule } from '@angular/cdk/layout';
import {MatAutocompleteModule} from '@angular/material/autocomplete';



@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    NavbarComponent,
    FooterComponent,
    CardComponent,
    NotFoundComponent,
    StudentComponent,
    CompanyComponent,
    StudentInfoCardComponent,
    StudentCompetenciesComponent,
    MainNavComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    JobAdsModule,
    NgbModule,
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatTabsModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonModule,
    LayoutModule,
    MatAutocompleteModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule {
}
