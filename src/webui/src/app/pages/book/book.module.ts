import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookComponent } from './book.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import { BookRoutingModule } from './book.routing.module';



@NgModule({
  declarations: [BookComponent],
  imports: [
    BookRoutingModule,
    NgxDatatableModule,
    CommonModule
  ]
})
export class BookModule { }
