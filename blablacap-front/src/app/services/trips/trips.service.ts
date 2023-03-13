import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trip } from 'src/app/models/Trip';
import { ITripForm } from 'src/app/shared/models/trip-form.model';

@Injectable({
  providedIn: 'root'
})
export class TripsService {
  private API_SERVER = "http://localhost:7000/trips";
  fecha = new Date();
  hora: number = Date.now();
  format = 'yyyy-MM-dd';
  locale = 'en-US';
  public formattedDate = formatDate(this.fecha, this.format, this.locale);
  public result: any;

  constructor(
    private httpClient : HttpClient
  ) { }

  public getTrips(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }
  public createTrip(trip: ITripForm): Observable<ITripForm> {
    console.log("entrada trip para mandarlo: " + trip.departure_date);
    /* console.log("id vehicle: " + trip.vehicle); */
    return this.httpClient.post<ITripForm>(this.API_SERVER + "/create", trip);
  }
  public setTrip(trip:Trip): Observable<any>{
    return this.httpClient.post<any>(this.API_SERVER+"/settrip", trip);
  }
  public getTripsSearched(filters: string): Observable<any>{
    console.log("entrada al getTripsSearched: " + filters);
    return this.httpClient.get<any>(this.API_SERVER + '/search?filters=' + filters);
  }
  public searchBar(keys: string) {
    this.result = keys;
    console.log("result dentro del searchBar: ---> " + this.result);
  }
}
