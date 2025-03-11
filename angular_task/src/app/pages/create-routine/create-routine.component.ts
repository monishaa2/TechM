import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { WorkoutService } from '../../services/workout.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-routine',
  templateUrl: './create-routine.component.html',
  styleUrls: ['./create-routine.component.css']
})
export class CreateRoutineComponent {
  routineForm: FormGroup;
  
  // ✅ Define missing properties
  workoutTypes: string[] = ['Cardio', 'Strength Training', 'Yoga', 'Pilates', 'HIIT', 'CrossFit', 'Stretching'];
  intensityLevels: string[] = ['Low', 'Medium', 'High'];
  daysOfWeek: string[] = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

  selectedDays: string[] = []; // ✅ Store selected days

  constructor(
    private fb: FormBuilder,
    private workoutService: WorkoutService,
    private router: Router
  ) {
    this.routineForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      duration: [0, [Validators.required, Validators.min(1)]],
      goal: [''],
      intensity: ['', Validators.required],
      days: [[]] // ✅ Store selected days
    });
  }

  // ✅ Method to toggle selected days
  toggleDay(event: any) {
    const day = event.target.value;
    if (event.target.checked) {
      this.selectedDays.push(day);
    } else {
      this.selectedDays = this.selectedDays.filter(d => d !== day);
    }
    this.routineForm.patchValue({ days: this.selectedDays });
  }

  submitRoutine() {
    if (this.routineForm.valid) {
      this.workoutService.addRoutine(this.routineForm.value).subscribe(() => {
        this.workoutService.getRoutines().subscribe(updatedRoutines => {
          this.router.navigate(['/my-routine']);
        });
      });
    } else {
      alert("Please fill all required fields correctly.");
    }
  }
  
  
}
