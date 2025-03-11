import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-workout-card',
  templateUrl: './workout-card.component.html',
  styleUrls: ['./workout-card.component.css']
})
export class WorkoutCardComponent {
  @Input() workout: any;
  @Output() remove = new EventEmitter<void>();

  removeRoutine() {
    this.remove.emit();
  }
}
