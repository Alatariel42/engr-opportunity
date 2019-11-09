import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTabsModule} from '@angular/material/tabs';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  imports: [
    CommonModule,
    MatToolbarModule,
    MatTabsModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule,
    MatIconModule
  ],
  exports: [
    MatToolbarModule,
    MatTabsModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule
  ],
  declarations: []
})
export class MaterialImportsModule { }
