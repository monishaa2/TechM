import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private apiUrl = 'http://localhost:3000/routines';

  constructor(private http: HttpClient) {}

  getRoutines(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  addRoutine(routine: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, routine);
  }
  

  removeRoutine(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
