import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { AppComponent }   from './app.component';
import {MatGridListModule} from '@angular/material/grid-list';
@NgModule({
    imports:      [ BrowserModule, FormsModule, MatGridListModule ],
    declarations: [ AppComponent ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }