import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './views/components/transmitter/register/register.component';

import { Presenter } from 'src/app/services/api/presenter/presenter.service';
import { Config } from './utils/config/app.config';
import { CategoryService } from './services/api/category.service';
import { HttpClientModule } from '@angular/common/http';
import { MyCounterComponent } from './views/components/demo/my-counter/my-counter.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    MyCounterComponent,
    MyCounterComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [Presenter, CategoryService, Config],
  bootstrap: [AppComponent],
})
export class AppModule {}
