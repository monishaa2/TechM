import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateRoutineComponent } from './pages/create-routine/create-routine.component';
import { HomeComponent } from './pages/home/home.component';
import { MyRoutineComponent } from './pages/my-routine/my-routine.component';
import { ProgressTrackerComponent } from './pages/progress-tracker/progress-tracker.component';
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'create-routine', component: CreateRoutineComponent } ,
  { path: 'my-routine', component: MyRoutineComponent },
  { path: 'progress', component: ProgressTrackerComponent }
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
