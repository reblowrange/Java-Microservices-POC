import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ByteToMbPipe } from './byte-to-mb.pipe';
import { ReverseArrayPipe } from './reverse-array.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ByteToMbPipe,
    ReverseArrayPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
