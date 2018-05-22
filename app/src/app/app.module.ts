import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './page/home/home.component';
import { NavComponent } from './nav/nav.component';
import { LoginComponent } from './page/login/login.component';
import { RegisterComponent } from './page/register/register.component';
import { AboutComponent } from './page/about/about.component';

const appRoutes: Routes = [
	{ path: 'home', component: HomeComponent },
	{ path: 'login', component: LoginComponent },
	{ path: 'register', component: RegisterComponent },
	{ path: 'about', component: AboutComponent },
	{ path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavComponent,
    LoginComponent,
    RegisterComponent,
    AboutComponent,
  ],
  imports: [
    BrowserModule,
	RouterModule.forRoot(
		appRoutes,
		//{ enableTracing: true } // <-- debugging purposes only
	)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
