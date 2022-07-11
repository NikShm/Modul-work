import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from "@angular/router";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './app/products/products.component';
import { AboutComponent } from './app/about/about.component';
import { HomeComponent } from './app/home/home.component';
import { LoginComponent } from './app/login/login.component';
import { CartComponent } from './app/cart/cart.component';
import { FavouriteComponent } from './app/favourite/favourite.component';
import {ProductService} from "./product.service";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

const AppRoutes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'about', component:AboutComponent},
  {path: 'products', component:ProductsComponent},
  {path: 'login', component:LoginComponent},
  {path: 'cart', component:CartComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    AboutComponent,
    HomeComponent,
    LoginComponent,
    CartComponent,
    FavouriteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(AppRoutes),
    HttpClientModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }


/*
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { AppComponent }   from './app.component';
import {ProductService} from "./product.service";
import { HttpClientModule } from '@angular/common/http';
@NgModule({
    imports:      [ BrowserModule, FormsModule, HttpClientModule ],
    declarations: [ AppComponent ],
    providers: [ProductService],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }
*/
