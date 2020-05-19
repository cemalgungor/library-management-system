
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams, } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { catchError } from 'rxjs/operators/catchError';
import { environment } from "../../environments/environment";

@Injectable()
export class ApiService {

 
  constructor(private http: HttpClient) {
  }

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.get('http://localhost:8000/api' + path, {params}).pipe(catchError(this.formatError));
  }


  private formatError(error: any) {
    return Observable.of("http://localhost:8000/api" + error.error);
  }
}