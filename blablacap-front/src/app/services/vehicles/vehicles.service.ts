import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehiclesService {
  private API_SERVER = "http://localhost:7000/vehicles";

  constructor(
    private httpClient : HttpClient
  ) { }

  public getVehicles(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public setVehicle(formData:FormData): Observable<any>{
    return this.httpClient.post<any>(this.API_SERVER+"/setvehicle", formData);
  }
  
}
