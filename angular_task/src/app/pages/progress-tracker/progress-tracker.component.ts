import { Component, OnInit } from '@angular/core';
import { WorkoutService } from '../../services/workout.service';

@Component({
  selector: 'app-progress-tracker',
  templateUrl: './progress-tracker.component.html',
  styleUrls: ['./progress-tracker.component.css']
})
export class ProgressTrackerComponent implements OnInit {
  totalWorkoutDays: number = 0;
  totalWorkoutMinutes: number = 0;
  consistencyScore: string = 'Low';

  constructor(private workoutService: WorkoutService) {}

  ngOnInit() {
    this.calculateProgress();
  }

  calculateProgress() {
    this.workoutService.getRoutines().subscribe(routines => {
      this.totalWorkoutDays = routines.length;
      this.totalWorkoutMinutes = routines.reduce((sum: number, routine: any) => sum + routine.duration, 0);

      // Set consistency score based on workout days
      if (this.totalWorkoutDays >= 20) {
        this.consistencyScore = "🔥 You're unstoppable! Keep pushing!";
      } else if (this.totalWorkoutDays >= 10) {
        this.consistencyScore = "💪 Great job! Stay consistent!";
      } else if (this.totalWorkoutDays >= 2) {
        this.consistencyScore = "👏 You're getting there! Keep going!";
      } else {
        this.consistencyScore = "🌱 Every step counts! Start today!";
      }
    });
  }
}
