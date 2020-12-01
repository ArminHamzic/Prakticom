import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import {MaterialModule} from '../material.module';
import { MemberCardComponent } from './member-card/member-card.component';



@NgModule({
  declarations: [HeaderComponent, HomeComponent, MemberCardComponent],
  imports: [
    CommonModule,
      MaterialModule
  ],
  exports: [
    HeaderComponent,
    HomeComponent
  ]
})
export class LayoutModule { }
