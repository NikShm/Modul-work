import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from 'ngx-pagination';

import { AppComponent } from './app.component';
import { ProductsComponent } from './components/products/products.component';
import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { CartComponent } from './components/cart/cart.component';
import { FavouriteComponent } from './components/favourite/favourite.component';
import { HeaderComponent } from './shared/layout/header/header.component';
import { FooterComponent } from './shared/layout/footer/footer.component';
import { ProductComponent } from './components/product/product.component';
import { AboutIconsComponent } from './shared/layout/about-icons/about-icons.component';

import {ProductService} from "./services/product.service";

import { FormatPipe } from './pipes/format.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    AboutComponent,
    HomeComponent,
    LoginComponent,
    CartComponent,
    FavouriteComponent,
    HeaderComponent,
    FooterComponent,
    ProductComponent,
    AboutIconsComponent,
    FormatPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }