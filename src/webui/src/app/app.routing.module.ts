import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './security/auth.guard';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
   {
    path: '', canActivate: [AuthGuard],
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'book'},
         {path: 'book',  loadChildren : () => import('./pages/book/book.module').then(m => m.BookModule)},
         {path: 'dashboard',  loadChildren : () => import('./pages/dashboard/dashboard.module').then(m => m.DashboardModule)}
       ]
  },
    {path: 'login', component: LoginComponent},
      {path: 'register', component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
