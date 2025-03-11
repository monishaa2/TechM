import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CreateRoutineComponent } from './pages/create-routine/create-routine.component'; 
import { AppRoutingModule } from './app-routing.module';
import { MyRoutineComponent } from './pages/my-routine/my-routine.component';
import { FormsModule } from '@angular/forms';
import { MenuBarComponent } from './common/menu-bar/menu-bar.component';
import { ProgressTrackerComponent } from './pages/progress-tracker/progress-tracker.component';
import { WorkoutCardComponent } from './pages/my-routine/workout-card/workout-card.component';
import { WorkoutService } from './services/workout.service';
import { ReactiveFormsModule } from '@angular/forms';
import { DurationPipe } from './pipes/duration.pipe';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CreateRoutineComponent,
    MyRoutineComponent,
    MenuBarComponent,
    ProgressTrackerComponent,
    WorkoutCardComponent,
    DurationPipe,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    CommonModule
  ],
  
  bootstrap: [AppComponent],providers: [WorkoutService]

})
export class AppModule { }
