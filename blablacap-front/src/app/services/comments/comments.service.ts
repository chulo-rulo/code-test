import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  private API_SERVER = "http://localhost:7000/comments/last";
  constructor(
    private httpClient : HttpClient
  ) { }


  public getLastComments(): Observable<any>{
      return this.httpClient.get(this.API_SERVER);
  }
}
