import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'duration'
})
export class DurationPipe implements PipeTransform {
  transform(value: number): string {
    if (value < 30) {
      return `${value} minutes (Short workout)`;
    } else if (value <= 60) {
      return `${value} minutes (Moderate workout)`;
    } else {
      return `${value} minutes (Intense workout)`;
    }
  }
}
