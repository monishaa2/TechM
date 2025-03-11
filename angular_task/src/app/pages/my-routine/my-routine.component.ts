import { Component, OnInit } from '@angular/core';
import { WorkoutService } from '../../services/workout.service';

@Component({
  selector: 'app-my-routine',
  templateUrl: './my-routine.component.html',
  styleUrls: ['./my-routine.component.css']
})
export class MyRoutineComponent implements OnInit {
  routines: any[] = [];

  constructor(private workoutService: WorkoutService) {}

  ngOnInit() {
    this.loadRoutines();
  }
  
  loadRoutines() {
    this.workoutService.getRoutines().subscribe(data => {
      this.routines = data;
    });
  }
  
  removeRoutine(id: number) {
    this.workoutService.removeRoutine(id).subscribe(() => {
      this.loadRoutines(); // Reload data after removing a routine
    });
  }
  

  
}
