import { MaterialImportsModule } from './material-imports/material-imports.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { CurriculumComponent } from './curriculum/curriculum.component';
import { NewsComponent } from './news/news.component';
import { GetInvolvedComponent } from './get-involved/get-involved.component';
import { HeaderComponent } from './header/header.component';

import {FlexLayoutModule, BREAKPOINT} from '@angular/flex-layout';

const routes: Routes = [
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'curriculum',
    component: CurriculumComponent
  },
  {
    path: 'news',
    component: NewsComponent
  },
  {
    path: 'get-involved',
    component: GetInvolvedComponent
  },
  {
    path: '',
    redirectTo: '/about',
    pathMatch: 'full'
  }
];
@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    CurriculumComponent,
    NewsComponent,
    GetInvolvedComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes),
    MaterialImportsModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
